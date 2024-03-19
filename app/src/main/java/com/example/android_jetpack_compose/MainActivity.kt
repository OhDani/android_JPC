package com.example.android_jetpack_compose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
//import androidx.activity.enableEdgeToEdge
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.annotation.VisibleForTesting
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.AlertDialogDefaults.shape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.android_jetpack_compose.ui.theme.ArtSpaceTheme
import java.text.NumberFormat
import kotlin.math.ceil

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
//        enableEdgeToEdge()
        super.onCreate(savedInstanceState)
        setContent {
            ArtSpaceTheme {
                Surface(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(MaterialTheme.colorScheme.secondary),
                    color = MaterialTheme.colorScheme.background,
                ) {
                    ArtSpaceLayout()
                }
            }
        }
    }
}

@Composable
fun ArtSpaceLayout () {
    var currentIndex by remember { mutableStateOf(0) }
    val imageList = listOf(R.drawable.art1, R.drawable.art2, R.drawable.art3)
    val authorList = listOf(R.string.art_author1, R.string.art_author2, R.string.art_author3) // Danh sách tác giả
    val artList = listOf(R.string.art_1, R.string.art_2, R.string.art_3)

    Column(
        modifier = Modifier
            .statusBarsPadding()
            .padding(horizontal = 40.dp)
            .verticalScroll(rememberScrollState())
            .safeDrawingPadding(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Box(
            modifier = Modifier
                .padding(10.dp)
                .shadow(15.dp)
        ) {
            Surface(
                modifier = Modifier
                    .clickable {
                        currentIndex = (currentIndex - 1).coerceAtLeast(0)
                    }
                    .fillMaxSize()
            ) {
                Image(
                    painter = painterResource(id = imageList[currentIndex]),
                    contentDescription = "Art Image",

                )
            }
        }

        Spacer(modifier = Modifier.height(40.dp))
        Text(
            text = "${stringResource(id = artList[currentIndex])}\n${stringResource(id = authorList[currentIndex])}",
            style = MaterialTheme.typography.bodyLarge,
            modifier = Modifier
                .background(color = Color.LightGray, shape = RectangleShape)
                .clickable {
                    currentIndex = (currentIndex - 1).coerceAtLeast(0)
                }
                .padding(8.dp)
        )
        Spacer(modifier = Modifier.height(20.dp))
        Row(
            horizontalArrangement = Arrangement.SpaceEvenly,
            modifier = Modifier.fillMaxWidth()
        ) {
            // Button previous
            Surface(
                modifier = Modifier
                    .border(BorderStroke(2.dp, Color.Blue), shape)
                    .padding(horizontal = 20.dp, vertical = 8.dp),
//                    .size(100.dp, 50.dp)
//                    .align(Alignment.CenterVertically),
                onClick = {
                    currentIndex = (currentIndex - 1).coerceAtLeast(0)
                }
            ) {
                Text(text = "Previous", modifier = Modifier.align(Alignment.CenterVertically))
            }

            // Button next
            Surface(
                modifier = Modifier
                    .border(BorderStroke(2.dp, Color.Blue), shape)
                    .padding(horizontal = 20.dp, vertical = 8.dp),
//                    .size(100.dp, 50.dp)
//                    .align(Alignment.CenterVertically),
                onClick = {
                    currentIndex = (currentIndex + 1).coerceAtMost(imageList.size - 1)
                }
            ) {
                Text(text = "Next", modifier = Modifier.align(Alignment.CenterVertically))
            }
        }
    }
}
@Preview
@Composable
fun ArtSpaceLayoutTheme(){
    ArtSpaceTheme {
        ArtSpaceLayout()
    }
}