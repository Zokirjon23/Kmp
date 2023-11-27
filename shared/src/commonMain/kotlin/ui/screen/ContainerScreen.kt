package ui.screen

import androidx.compose.foundation.layout.RowScope
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.navigator.tab.CurrentTab
import cafe.adriel.voyager.navigator.tab.LocalTabNavigator
import cafe.adriel.voyager.navigator.tab.Tab
import cafe.adriel.voyager.navigator.tab.TabNavigator
import util.AppScreen
import util.text_color

class ContainerScreen : AppScreen {
    @Composable
    override fun Content() {
        ContainerContent()
    }

    @Composable
    fun ContainerContent() {
        TabNavigator(PassengerMapScreen()) {
            Scaffold(
                content = {
                    CurrentTab()
                },
                bottomBar = {
                    BottomAppBar(
//                        modifier = Modifier.height(60.dp)
                        modifier = Modifier.shadow(10.dp),
                        containerColor = Color.White

                    ) {
                        TabNavigationItem(PassengerMapScreen())
                        TabNavigationItem(DirectionScreen())
                        TabNavigationItem(ChatUserScreen())
                        TabNavigationItem(PassengerSettingScreen())
                    }
                }
            )
        }
    }

    @Composable
    fun RowScope.TabNavigationItem(tab: Tab) {
        val tabNavigator = LocalTabNavigator.current
        val selected = tabNavigator.current.options.index == tab.options.index
        NavigationBarItem(
            icon = { Icon(tab.options.icon!!, contentDescription = tab.options.title,tint = if (selected) text_color else text_color.copy(0.5f)) },
            label = { Text(tab.options.title,color = if (selected) text_color else text_color.copy(0.5f)) },
            selected = selected,
            onClick = { tabNavigator.current = tab }
        )
    }
}