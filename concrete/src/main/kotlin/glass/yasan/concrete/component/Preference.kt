package glass.yasan.concrete.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import glass.yasan.concrete.theme.ConcreteTheme
import glass.yasan.spine.compose.foundation.grid

@Composable
public fun Preference(
    title: @Composable () -> Unit,
    modifier: Modifier = Modifier,
    description: @Composable (() -> Unit)? = null,
    applyPaddings: Boolean = true,
    start: @Composable (() -> Unit)? = null,
    end: @Composable (() -> Unit)? = null,
) {
    val paddingValue = if (applyPaddings) 2.grid else 0.grid

    TopBar(
        modifier = modifier,
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(paddingValue),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            start?.let { it() }
            Column(
                modifier = Modifier.weight(1f),
            ){
                title()
                description?.let { it() }
            }
            end?.let { it() }
        }
    }
}

// region Preview

@Preview
@Composable
private fun PreferenceLayoutPreview() {
    ConcreteTheme {
        Preference(
            start = {
                Text(
                    modifier = Modifier.background(Color.Red),
                    text = "Start",
                )
            },
            title = {
                Text(
                    modifier = Modifier.background(Color.Green),
                    text = "Title",
                )
            },
            description = {
                Text(
                    modifier = Modifier.background(Color.Blue),
                    text = "Description",
                )
            },
            end = {
                Text(
                    modifier = Modifier.background(Color.Red),
                    text = "End",
                )
            },
        )
    }
}

// endregion Preview
