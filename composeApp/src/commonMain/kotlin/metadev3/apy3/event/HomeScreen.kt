package metadev3.apy3.event

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import kotlinproject.composeapp.generated.resources.Res
import kotlinproject.composeapp.generated.resources.bg_gradient
import kotlinproject.composeapp.generated.resources.logo_md3
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.painterResource

@OptIn(ExperimentalResourceApi::class)
@Composable
fun HomeScreen(navController: NavController) {
    var email by remember { mutableStateOf("") }
    var isEmailValid by remember { mutableStateOf(true) }

    Box(modifier = Modifier.fillMaxSize()) {
        // Background Image
        Image(
            painter = painterResource(Res.drawable.bg_gradient),
            contentDescription = "Background",
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )

        // Content
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
                .verticalScroll(rememberScrollState()),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Logo
            Image(
                painter = painterResource(Res.drawable.logo_md3),
                contentDescription = "Logo",
                modifier = Modifier
                    .size(120.dp)
                    .padding(top = 32.dp, bottom = 16.dp)
            )

            Text(
                text = "APY 3 EVENTS",
                style = MaterialTheme.typography.h4,
                modifier = Modifier.padding(bottom = 32.dp)
            )
            
            OutlinedTextField(
                value = email,
                onValueChange = { 
                    email = it
                    isEmailValid = isValidEmail(it)
                },
                label = { Text("Enter your email") },
                isError = !isEmailValid,
                modifier = Modifier.fillMaxWidth()
            )
            
            if (!isEmailValid) {
                Text(
                    text = "Please enter a valid email address",
                    color = MaterialTheme.colors.error,
                    modifier = Modifier.padding(top = 4.dp)
                )
            }
            
            Spacer(modifier = Modifier.height(16.dp))
            
            Button(
                onClick = { 
                    if (isValidEmail(email)) {
                        // TODO: Implement API call
                        navController.navigate("events")
                    }
                },
                enabled = isEmailValid && email.isNotEmpty(),
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("View My NFTs")
            }
        }
    }
}

fun isValidEmail(email: String): Boolean {
    return android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()
}