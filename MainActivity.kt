package com.aienhancestudio

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.Gravity
import android.view.ViewGroup
import android.widget.Button
import android.widget.LinearLayout
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast

class MainActivity : Activity() {
    private lateinit var status: TextView
    private lateinit var selectedText: TextView
    private var selectedVideo: Uri? = null

    private val pickVideo = 1001

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val root = LinearLayout(this).apply {
            orientation = LinearLayout.VERTICAL
            gravity = Gravity.CENTER_HORIZONTAL
            setPadding(32, 48, 32, 32)
            setBackgroundColor(0xFF101018.toInt())
        }

        val title = TextView(this).apply {
            text = "AI Enhance Studio"
            textSize = 28f
            setTextColor(0xFFFFFFFF.toInt())
            gravity = Gravity.CENTER
        }

        val subtitle = TextView(this).apply {
            text = "Video enhancement prototype"
            textSize = 15f
            setTextColor(0xFFB9B9C8.toInt())
            gravity = Gravity.CENTER
        }

        selectedText = TextView(this).apply {
            text = "No video selected"
            textSize = 14f
            setTextColor(0xFFFFFFFF.toInt())
            setPadding(0, 28, 0, 16)
        }

        val chooseButton = Button(this).apply {
            text = "Select video"
            setOnClickListener {
                val intent = Intent(Intent.ACTION_OPEN_DOCUMENT).apply {
                    addCategory(Intent.CATEGORY_OPENABLE)
                    type = "video/*"
                }
                startActivityForResult(intent, pickVideo)
            }
        }

        val enhanceButton = Button(this).apply {
            text = "Send to AI processing"
            setOnClickListener {
                if (selectedVideo == null) {
                    Toast.makeText(this@MainActivity, "Select a video first", Toast.LENGTH_SHORT).show()
                } else {
                    status.text = "Prototype only: connect a secured backend to enable AI processing."
                }
            }
        }

        status = TextView(this).apply {
            text = "Choose a short sample video to begin."
            textSize = 14f
            setTextColor(0xFFDDDDDD.toInt())
            setPadding(0, 24, 0, 0)
        }

        val note = TextView(this).apply {
            text = "AI inference is not connected yet. This starter does not enhance or upload your video."
            textSize = 12f
            setTextColor(0xFFB9B9C8.toInt())
            setPadding(0, 20, 0, 0)
        }

        root.addView(title, matchWrap())
        root.addView(subtitle, matchWrap())
        root.addView(selectedText, matchWrap())
        root.addView(chooseButton, matchWrap())
        root.addView(enhanceButton, matchWrap())
        root.addView(status, matchWrap())
        root.addView(note, matchWrap())
        setContentView(root)
    }

    @Deprecated("Deprecated in Android but retained for broad compatibility in this starter")
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == pickVideo && resultCode == RESULT_OK) {
            selectedVideo = data?.data
            selectedText.text = selectedVideo?.lastPathSegment ?: "Video selected"
            status.text = "Video selected. AI processing is not connected yet."
        }
    }

    private fun matchWrap(): LinearLayout.LayoutParams =
        LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT)
}
