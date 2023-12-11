package com.example.tubes.ui.askica
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.tubes.data.ChatData
import com.example.tubes.data.ChatResponse
import com.example.tubes.data.OpenAIAPI
import com.example.tubes.databinding.ActivityAskIcaBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class AskIcaActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAskIcaBinding
    private lateinit var chatAdapter: ChatAdapter
    private val chatList = mutableListOf<Pair<String, String>>()

    private val apiKey = "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"
    private val openAIAPI: OpenAIAPI

    init {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://api.openai.com/v1/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        openAIAPI = retrofit.create(OpenAIAPI::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAskIcaBinding.inflate(layoutInflater)
        setContentView(binding.root)

        chatAdapter = ChatAdapter(chatList)
        binding.rvBot.adapter = chatAdapter
        binding.rvBot.layoutManager = LinearLayoutManager(this)

        binding.fabChat.setOnClickListener {
            val message = binding.edtChatIca.text.toString()
            if (message.isNotEmpty()) {
                sendMessage(message)
                binding.edtChatIca.text.clear()
            }
        }
    }

    private fun sendMessage(message: String) {
        val userMessage = Pair("You", message)
        chatList.add(userMessage)
        chatAdapter.notifyItemInserted(chatList.size - 1)
        binding.rvBot.scrollToPosition(chatList.size - 1)

        val chatInput = ChatData("gpt-3.5-turbo", "You: $message", 0.7)

        val call = openAIAPI.getChatResponse(apiKey, chatInput)
        call.enqueue(object : Callback<ChatResponse> {
            override fun onResponse(call: Call<ChatResponse>, response: Response<ChatResponse>) {
                val botReply = response.body()?.choices?.get(0)?.message ?: "No response"
                val botMessage = Pair("Bot", botReply)
                runOnUiThread {
                    chatList.add(botMessage)
                    chatAdapter.notifyItemInserted(chatList.size - 1)
                    binding.rvBot.scrollToPosition(chatList.size - 1)
                }
            }

            override fun onFailure(call: Call<ChatResponse>, t: Throwable) {
                t.printStackTrace()
            }
        })
    }
}
