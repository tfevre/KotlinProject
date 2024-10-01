package metadev3.apy3.event

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun HomeScreen(navController: NavController) {
    var email by remember { mutableStateOf("") }
    var isEmailValid by remember { mutableStateOf(true) }

    Column(
        modifier = Modifier.fillMaxSize().padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "NFT Viewer",
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

fun isValidEmail(email: String): Boolean {
    return android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()
}