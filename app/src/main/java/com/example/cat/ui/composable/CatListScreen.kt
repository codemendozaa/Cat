import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import com.example.cat.CatViewModel

@Composable
fun CatListScreen(viewModel: CatViewModel) {
    val catList by remember { viewModel.breeds }.observeAsState(emptyList())

    LaunchedEffect(key1 = true) {
        viewModel.loadBreeds()
    }

    LazyColumn {
        items(catList)
         { breed ->
            Row(
                Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            ) {
                CoilImage(
                    data = breed.image ?: "",
                    contentDescription = breed.name ?: "",
                    modifier = Modifier.size(64.dp)
                )
                Spacer(modifier = Modifier.width(16.dp))
                Column {
                    Text(text = breed.name, style = MaterialTheme.typography.h5)
                    Text(text = breed.origin, style = MaterialTheme.typography.body1)
                }
            }
        }
    }
}



@Composable
fun CoilImage(
    data: String,
    contentDescription: String?,
    modifier: Modifier = Modifier,
    contentScale: ContentScale = ContentScale.Fit,
    error: Painter? = null,
    loading: Painter? = null,
) {
    val painter = rememberImagePainter(
        data = data,
        builder = {
            error?.let { error(it) }
          //  loading?.let { placeholder(it) }
        }
    )
    Image(
        painter = painter,
        contentDescription = contentDescription,
        modifier = modifier,
        contentScale = contentScale,
    )
}



