package metadev3.apy3.event

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun QRScannerScreen(navController: NavController) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Scan QR Code") },
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        // TODO: Add back icon
                    }
                }
            )
        }
    ) { padding ->
        Column(
            modifier = Modifier.fillMaxSize().padding(padding),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text("QR Scanner Placeholder")
            Text("(Implement platform-specific scanner here)")
            Spacer(modifier = Modifier.height(16.dp))
            Button(onClick = {
                // Simulate successful scan
                // TODO: Implement actual QR scanning and API call
                navController.navigate("events")
            }) {
                Text("Simulate Scan")
            }
        }
    }
}