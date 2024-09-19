package com.example.roblox

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.foundation.clickable
import androidx.compose.ui.platform.LocalContext
import android.widget.Toast
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Notifications

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApp()
        }
    }
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyApp() {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Inicio") },
                actions = {
                    IconButton(onClick = { /*TODO*/ }) {
                        Icon(imageVector = Icons.Default.Search, contentDescription = "Símbolo Buscar")
                    }
                    IconButton(onClick = { /*TODO*/ }) {
                        Icon(imageVector = Icons.Default.Info, contentDescription = "Símbolo Bobux")
                    }
                    IconButton(onClick = { /*TODO*/ }) {
                        Icon(imageVector = Icons.Default.Notifications, contentDescription = "Notificaciones")
                    }
                }
            )
        },
        bottomBar = {
            BottomNavigationBar()
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(5.dp)
        ) {
            //Mi perfil
            LazyRow(modifier = Modifier.padding(bottom = 5.dp)) {
                items(listOf(
                    Pair("Clartix1", R.drawable.yo),
                )) { friend ->
                    FriendItem(name = friend.first, imageResId = friend.second)
                }
            }
//Parte de Amigos


            // Cantidad de amigos
            Text(
                text = "Amigos(7) →",
                style = MaterialTheme.typography.titleLarge,
                modifier = Modifier.padding(bottom = 5.dp)
            )

            // Parte de amigos
            LazyRow(modifier = Modifier.padding(bottom = 5.dp)) {
                items(listOf(
                    Pair("Amigo 1", R.drawable.amigo1),
                    Pair("Amigo 2", R.drawable.amigo2),
                    Pair("Amigo 3", R.drawable.amigo3),
                    Pair("Amigo 4", R.drawable.amigo4),
                    Pair("Amigo 5", R.drawable.amigo5),
                    Pair("Amigo 6", R.drawable.amigo6),
                    Pair("Amigo 7", R.drawable.amigo7)
                )) { friend ->
                    FriendItem(name = friend.first, imageResId = friend.second)
                }
            }

            // Sección de recomendaciones
            Text(
                "Recomendaciones para ti",
                style = MaterialTheme.typography.titleLarge,
                modifier = Modifier.padding(bottom = 1.dp)
            )

            // Juegos en dos columnas
            LazyColumn {
                items(listOf(
                    Triple("Dress to Impress", "91%", R.drawable.juego11),
                    Triple("Come slimes para s..", "72%", R.drawable.juego21),
                    Triple("Juntos [Juego de Fie...", "83%", R.drawable.juego31),
                    Triple("La Cabaña [HORROR]", "72%", R.drawable.juego41),
                    Triple("Adopt Me", "91%", R.drawable.juego1),
                    Triple("Bee Sim", "56%", R.drawable.juego2),
                    Triple("Piggy", "72%", R.drawable.juego3),
                    Triple("JailBreaker", "83%", R.drawable.juego4),
                    Triple("BorBux", "75%", R.drawable.juego5),
                    Triple("Tower of Hell", "93%", R.drawable.juego6)
                ).chunked(2)) { rowItems ->
                    Row(modifier = Modifier.fillMaxWidth()) {
                        for (item in rowItems) {
                            GameRecommendationItem(
                                gameName = item.first,
                                rating = item.second,
                                imageResId = item.third,
                                modifier = Modifier.weight(1f)
                            )
                        }
                    }
                }
            }

            Spacer(modifier = Modifier.weight(1f))
        }
    }
}

@Composable
fun BottomNavigationBar() {
    val context = LocalContext.current

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.White)
            .padding(8.dp),
        horizontalArrangement = Arrangement.SpaceAround
    ) {
        BottomNavigationItem(
            imageResId = R.drawable.home,
            abajo = "Home",
            onClick = { /*TODO*/ }
        )
        BottomNavigationItem(
            imageResId = R.drawable.dest,
            abajo = "Destacados",
            onClick = { /*TODO*/ }
        )
        BottomNavigationItem(
            imageResId = R.drawable.avatar,
            abajo = "Avatar",
            onClick = { /*TODO*/ }
        )
        BottomNavigationItem(
            imageResId = R.drawable.chat,
            abajo = "Chat",
            onClick = { /*TODO*/ }
        )
        BottomNavigationItem(
            imageResId = R.drawable.more,
            abajo = "More",
            onClick = { /*TODO*/ }
        )
    }
}

@Composable
fun BottomNavigationItem(imageResId: Int, abajo: String, onClick: () -> Unit) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .clickable(onClick = onClick)
            .padding(5.dp)
    ) {
        Image(
            painter = painterResource(id = imageResId),
            contentDescription = abajo,
            modifier = Modifier.size(30.dp).clip(CircleShape)
        )
        Text(
            text = abajo,
            fontSize = 10.sp,
            color = Color.White,
            modifier = Modifier.padding(top = 4.dp)
        )
    }
}

@Composable
fun FriendItem(name: String, imageResId: Int) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.padding(horizontal = 6.dp)
    ) {
        Box(
            modifier = Modifier
                .size(60.dp)
                .border(2.dp, Color.Gray, CircleShape)
                .clip(CircleShape)
        ) {
            Image(
                painter = painterResource(id = imageResId),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxSize()
            )
        }
        Text(
            name,
            fontSize = 12.sp,
            modifier = Modifier.padding(top = 4.dp),
            textAlign = TextAlign.Center,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis
        )
    }
}

@Composable
fun GameRecommendationItem(gameName: String, rating: String, imageResId: Int, modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .padding(5.dp)
            .padding(5.dp)
    ) {
        Image(
            painter = painterResource(id = imageResId),
            contentDescription = null,
            modifier = Modifier
                .size(150.dp)
                .clip(RectangleShape)
        )

        Spacer(modifier = Modifier.width(5.dp))

        Column(modifier = Modifier.fillMaxWidth()) {
            Text(
                gameName,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(bottom = 4.dp)
            )
            Text(
                "Valoración: $rating",
                style = MaterialTheme.typography.bodyMedium,
                color = Color.Gray
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MyApp()
}
