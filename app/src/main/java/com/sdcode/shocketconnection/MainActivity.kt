package com.sdcode.shocketconnection

import android.os.AsyncTask
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import java.io.IOException
import java.lang.Exception
import java.net.Socket
import java.net.UnknownHostException

class MainActivity : AppCompatActivity() {
    val TAG = "MainActivity"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var etIP: EditText = findViewById(R.id.etIP);
        var etPORT: EditText = findViewById(R.id.etPORT);
        var tvLogs: TextView = findViewById(R.id.tvLogs);
        var btnConnect: AppCompatButton = findViewById(R.id.btnConnect);
        var btnClearLog: AppCompatButton = findViewById(R.id.btnClearLog);

        btnConnect.setOnClickListener(View.OnClickListener {
            try {
                var connectionSocket = ConnectSocket()
                val ip = etIP.text.toString()
                val port = etPORT.text.toString()
                connectionSocket.execute(ip, port)
            } catch (e: Exception) {
                e.printStackTrace();
                Log.d(TAG, "Exception -->" + e.message.toString())
                Toast.makeText(
                    applicationContext,
                    "Exception -->" + e.message.toString(),
                    Toast.LENGTH_SHORT
                ).show()
            }
        })
        btnClearLog.setOnClickListener(View.OnClickListener
        {
            tvLogs.text = "Logs"
        })
    }
}