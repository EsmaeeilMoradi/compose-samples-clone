package com.esm.jetsnack_clone.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.esm.jetsnack_clone.ui.JetsnackAppClone
import com.esm.jetsnack_clone.ui.theme.AppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetsnackAppClone()
        }
    }
}
