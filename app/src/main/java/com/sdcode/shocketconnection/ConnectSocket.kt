package com.sdcode.shocketconnection

import android.os.AsyncTask
import android.util.Log
import java.io.IOException
import java.lang.Exception
import java.net.Socket
import java.net.UnknownHostException


class ConnectSocket : AsyncTask<String, Int, Void>() {
    var s = Socket()
    val TAG = "ConnectSocket"

    override fun doInBackground(vararg p0: String?): Void? {
        val ip = p0[0]
        val port = p0[1]
        Log.d(TAG, "IP -> $ip   PORT -> $port")
        if (!ip.equals("") && !port.equals("")) {
            Log.d(TAG, "Trying to Connect...")
            try {
                s = Socket(ip, Integer.parseInt(port))
                var output = s.getOutputStream();
                var input = s.getInputStream();
                Log.d(TAG, "Connected....")
            } catch (e: UnknownHostException) {
                e.printStackTrace();
                Log.d(TAG, "UnknownHostException -->" + e.message.toString())
            } catch (e: IOException) {
                e.printStackTrace();
                Log.d(TAG, "IOException -->" + e.message.toString())
            } catch (e: Exception) {
                e.printStackTrace();
                Log.d(TAG, "Exception -->" + e.message.toString())
            }
        } else {
            Log.d(TAG, "Fill all fields!")
        }
        return null
    }

    public fun checkConnection() {
        if (s.isBound) {
            Log.d(TAG, "Connected..")
        } else {
            Log.d(TAG, "Not Connected.")
        }
    }

    override fun onPostExecute(result: Void?) {
        checkConnection()
    }
}
/*
internal class ConnectSocket :
    AsyncTask<String?, Void?, RSSFeed?>() {
    private var exception: Exception? = null
    protected override fun doInBackground(vararg urls: String): RSSFeed? {
        return try {
            val url = URL(urls[0])
            val factory: SAXParserFactory = SAXParserFactory.newInstance()
            val parser: SAXParser = factory.newSAXParser()
            val xmlreader: XMLReader = parser.getXMLReader()
            val theRSSHandler = RssHandler()
            xmlreader.setContentHandler(theRSSHandler)
            val `is` = InputSource(url.openStream())
            xmlreader.parse(`is`)
            theRSSHandler.getFeed()
        } catch (e: Exception) {
            exception = e
            null
        } finally {
            `is`.close()
        }
    }

    override fun onPostExecute(feed: RSSFeed?) {
        // TODO: check this.exception
        // TODO: do something with the feed
    }
}*/