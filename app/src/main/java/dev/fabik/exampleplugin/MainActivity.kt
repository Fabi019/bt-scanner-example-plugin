package dev.fabik.exampleplugin

import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.LargeTopAppBar
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll


class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            val colorScheme = when (isSystemInDarkTheme()) {
                true -> if (Build.VERSION.SDK_INT > 31) dynamicDarkColorScheme(this) else darkColorScheme()
                false -> if (Build.VERSION.SDK_INT > 31) dynamicLightColorScheme(this) else lightColorScheme()
            }

            MaterialTheme(colorScheme) {
                MainContent()
            }
        }
    }

    @Composable
    @OptIn(ExperimentalMaterial3Api::class)
    fun MainContent() {
        val scrollBehavior = TopAppBarDefaults.exitUntilCollapsedScrollBehavior(rememberTopAppBarState())

        Scaffold(
            modifier = Modifier.nestedScroll(scrollBehavior.nestedScrollConnection),
            topBar = {
                LargeTopAppBar(
                    title = { Text(getString(R.string.app_name)) },
                    scrollBehavior = scrollBehavior
                )
            }
        ) {
            Box(Modifier.padding(it)) {
                Text("Add your content/settings here...")
            }
        }
    }

}