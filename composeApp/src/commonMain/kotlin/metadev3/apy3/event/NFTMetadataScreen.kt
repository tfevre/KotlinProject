package metadev3.apy3.event

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import kotlinproject.composeapp.generated.resources.Res
import kotlinproject.composeapp.generated.resources.compose_multiplatform
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.painterResource

@OptIn(ExperimentalResourceApi::class)
@Composable
fun NFTMetadataScreen(navController: NavController, eventId: String) {
    // In a real app, you would fetch this data from an API
    val metadata = remember {
        mapOf(
            "Event Name" to "Crypto Conference 2024",
            "Date" to "2024-03-15",
            "Description" to "A gathering of blockchain enthusiasts and industry leaders.",
            "Venue" to "Tech Center, Silicon Valley",
            "Token ID" to "#12345"
        )
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("NFT Details") },
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(
                            imageVector = Icons.Filled.ArrowBack,
                            contentDescription = "Back"
                        )
                    }
                }
            )
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .padding(padding)
                .verticalScroll(rememberScrollState())
        ) {
            // NFT Image
            Image(
                painter = painterResource(Res.drawable.compose_multiplatform),
                contentDescription = "NFT Image",
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp),
                contentScale = ContentScale.Crop
            )

            // Metadata
            Column(modifier = Modifier.padding(16.dp)) {
                metadata.forEach { (key, value) ->
                    MetadataItem(key, value)
                    Spacer(modifier = Modifier.height(8.dp))
                }
            }
        }
    }
}

@Composable
fun MetadataItem(key: String, value: String) {
    Column {
        Text(text = key, style = MaterialTheme.typography.caption)
        Text(text = value, style = MaterialTheme.typography.body1)
        Divider(modifier = Modifier.padding(vertical = 8.dp))
    }
}