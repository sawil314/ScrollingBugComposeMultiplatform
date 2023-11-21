import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.onSizeChanged
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.IntSize

@Composable
fun App() {
    MaterialTheme {
        ExampleAnalog()
    }
}

private val array1: ArrayList<List<String>> =
    arrayListOf(
        listOf("%", "aaa", "bbb", "ccc"),
        listOf("0", "-20", "-20", "4"),
        listOf("0", "-20", "-20", "4"),
        listOf("0", "-20", "-20", "4"),
        listOf("0", "-20", "-20", "4"),
        listOf("0", "-20", "-20", "4"),
    )
private val array3: ArrayList<List<String>> =
    arrayListOf(
        listOf("", "MIN 2", "MIN 1"),
        listOf("xxx", "10", "11"),
        listOf("yyy", "10", "11"),
        listOf("zz", "7,43", "7,54")
    )

private val array4: ArrayList<List<String>> =
    arrayListOf(
        listOf("", "jjj", " xxxxxxxx")
    )
private val array6: ArrayList<List<String>> =
    arrayListOf(
        listOf("", "hjl", " xxx xxxxx", "igtg")
    )


@Composable
fun ExampleAnalog(modifier: Modifier = Modifier) {
    val scrollState = rememberLazyListState()

    LazyColumn(
        state = scrollState,
        modifier = modifier
    ) {

        item {
            HeaderInformation(
            )
            Divider(
                thickness = 2.dp,
                color = Color.Red,
                modifier = Modifier.padding(Dimensions.paddingXSmall)
            )
        }
        item {
            HeaderText("yyy")
            Row() {
                Text(
                     " -00...000 xxxx",
                    modifier = Modifier.padding(horizontal = 16.dp).weight(1f)
                )
                Text(
                    "bla -00...000 xxxx",
                    modifier = Modifier.padding(horizontal =16.dp).weight(1f)
                )
            }
        }
        item {
            Column {
                MeasuringResultPlsAndSps(
                    array = array1,
                    plsList = listOf("", "", "", "", ""),
                    spsList = listOf("", "", "", "", ""),
                )
            }

            Divider(
                thickness = 2.dp,
                color = Color.Red,
                modifier = Modifier.padding(Dimensions.paddingXSmall)
            )
        }
        item { HeaderText("jjj") }
        item {
            MeasuringTable3()
            Divider(
                thickness = 2.dp,
                color = Color.Red,
                modifier = Modifier.padding(Dimensions.paddingXSmall)
            )
        }
        item { HeaderText("gfyjsztj") }
        item {
            MeasuringTable4()
            Divider(
                thickness = 2.dp,
                color = Color.Red,
                modifier = Modifier.padding(Dimensions.paddingXSmall)
            )
        }

        item { HeaderText("kkkk") }
        item {
            MeasuringTable5()
            Divider(
                thickness =2.dp,
                color = Color.Red,
                modifier = Modifier.padding(Dimensions.paddingXSmall)
            )
        }
        item { HeaderText("note") }
        item {
            OutlinedTextField(
                value = "",
                onValueChange = {  },
                label = { Text(text = "nnnn") },
                minLines = 3,
                modifier = Modifier.fillMaxWidth().padding(Dimensions.paddingSmall)
            )
        }
    }
}

@Composable
private fun MeasuringTable3() {
    LazyRow(
    ) {
        item {
            Column(Modifier.width(IntrinsicSize.Max)) {
                Row(
                    Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {
                    Text(
                        "Test", Modifier.height(Dimensions.defaultTextFieldHeight)
                            .wrapContentHeight(align = Alignment.CenterVertically)
                    )
                    Text(
                        "xxx ", Modifier.height(Dimensions.defaultTextFieldHeight)
                            .wrapContentHeight(align = Alignment.CenterVertically)
                    )
                }
                Row() {
                    for (i in array3.indices)
                        MeasuringColumnText(array3[i])
                }
            }
        }
        item {
            MeasuringColumnTextfield(
                list = listOf("", ""),
                headline = "xxx "
            )
        }
    }
}

@Composable
fun MeasuringTable4() {
    Row() {
        for (i in array4.indices) {
            MeasuringColumnText(array4[i])
        }
    }
}

@Composable
fun MeasuringTable5() {
    Row() {
        for (i in array6.indices) {
            MeasuringColumnText(array6[i])
        }
    }
}


@OptIn(ExperimentalLayoutApi::class)
@Composable
fun HeaderInformation(
    modifier: Modifier = Modifier,
) {
    FlowRow(modifier = modifier, horizontalArrangement = Arrangement.spacedBy(Dimensions.paddingSmall)) {
        OutlinedTextField(
            value = "",
            onValueChange = {  },
            label = { Text(text = "TEST") }
        )
        OutlinedTextField(
            value = "",
            onValueChange = {  },
            label = { Text(text = "TEST") }
        )
        OutlinedTextField(
            value = "",
            onValueChange = {  },
            label = { Text(text ="TEST") }
        )
    }
}

@Composable
fun MeasuringResultPlsAndSps(
    array: ArrayList<List<String>>,
    plsList: List<String>,
    spsList: List<String>,
    modifier: Modifier = Modifier,
) {
    var textField1Width by remember { mutableStateOf(0) }
    var textField2Width by remember { mutableStateOf(0) }
    Column(
        modifier = modifier.widthIn(max = 500.dp).padding(16.dp),
    ) {
        Column() {
            Row() {
                Text(
                    text = "TEST",
                    modifier = Modifier.weight(1f),
                    textAlign = TextAlign.Center
                )
                Text(
                    text = "TEST",
                    modifier = Modifier.width(textField1Width.pxToDp()),
                    textAlign = TextAlign.Center
                )
                Text(
                    text = "TEST",
                    modifier = Modifier.width(textField2Width.pxToDp()),
                    textAlign = TextAlign.Center
                )
            }
            Row(Modifier.height(Dimensions.defaultTextFieldHeight)) {
                for (i in 0..array.get(0).size - 1) {
                    Text(
                        text = array[0][i], Modifier.weight(1f).align(Alignment.CenterVertically),
                        textAlign = TextAlign.Center
                    )
                }
                Text(
                    "",
                    Modifier.width(textField1Width.pxToDp() + textField2Width.pxToDp() )
                )
            }
        }

        if (array.isNotEmpty()) {
            for (count in 0..(array.size - 2))
                MeasuringRow(
                    array = array.get(count + 1),
                    plsList = plsList,
                    spsList = spsList,
                    index = count,
                    onTextField1SizeChanged = { textField1Width = it.width },
                    onTextField2SizeChanged = { textField2Width = it.width },
                    modifier.height(Dimensions.defaultTextFieldHeight)
                )
        }
    }
}

@Composable
fun MeasuringRow(
    array: List<String>,
    plsList: List<String>,
    spsList: List<String>,
    index: Int,
    onTextField1SizeChanged: (IntSize) -> Unit,
    onTextField2SizeChanged: (IntSize) -> Unit,
    modifier: Modifier = Modifier
) {
    Row(modifier) {
        for (i in array.indices) {
            Text(
                text = array[i],
                modifier = Modifier.weight(1f).align(Alignment.CenterVertically),
                textAlign = TextAlign.Center,
            )
        }
        OutlinedTextField(
            value = plsList[index],
            onValueChange = { },
            modifier = Modifier.onSizeChanged(onTextField1SizeChanged).width(Dimensions.numberTextfieldWidth)
        )
        OutlinedTextField(
            value = spsList[index],
            onValueChange = {  },
            modifier = Modifier.onSizeChanged(onTextField2SizeChanged).width(Dimensions.numberTextfieldWidth)
        )
    }
}

@Composable
fun MeasuringColumnText(
    list: List<String>,
    modifier: Modifier = Modifier
) {
    Column(modifier.width(IntrinsicSize.Max)) {
        for (i in list.indices) {
            Text(
                text = list[i],
                modifier = Modifier.height(Dimensions.defaultTextFieldHeight).fillMaxWidth()
                    .padding(horizontal = Dimensions.paddingSmall)
                    .wrapContentHeight(align = Alignment.CenterVertically),
                textAlign = TextAlign.Center,
            )
        }
    }
}

@Composable
fun MeasuringColumnTextfield(
    list: List<String>,
    headline: String,
    modifier: Modifier = Modifier
) {
    Column(modifier.width(IntrinsicSize.Max)) {
        Text(
            headline,
            textAlign = TextAlign.Center,
            modifier = Modifier.height(Dimensions.defaultTextFieldHeight).fillMaxWidth()
                .wrapContentHeight(align = Alignment.CenterVertically)
        )
        Text(
            "",
            modifier = Modifier.height(Dimensions.defaultTextFieldHeight).fillMaxWidth()
                .wrapContentHeight(align = Alignment.CenterVertically)
        )
        for (i in list.indices) {
            OutlinedTextField(
                value = list[i],
                onValueChange = {  },
                modifier = Modifier.width(Dimensions.numberTextfieldWidth)
                    .padding(horizontal = Dimensions.paddingXSmall)
            )
        }
    }
}

@Composable
fun HeaderText(
    text: String
) {
    Text(
        text = text,
        fontWeight = FontWeight.Bold
    )
}

object Dimensions{
    val defaultTextFieldHeight = 56.dp
    val numberTextfieldWidth: Dp = 92.dp
    val paddingXSmall: Dp = 4.dp
    val paddingSmall: Dp = 8.dp
}

@Composable
fun Int.pxToDp() = with(LocalDensity.current) { this@pxToDp.toDp() }
