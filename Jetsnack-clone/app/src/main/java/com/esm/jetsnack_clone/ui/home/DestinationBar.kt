/*
 * Copyright 2020 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

@file:OptIn(ExperimentalSharedTransitionApi::class)

package com.esm.jetsnack_clone.ui.home

import android.content.res.Configuration
import androidx.compose.animation.ExperimentalSharedTransitionApi
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.WindowInsetsSides.Companion.Horizontal
import androidx.compose.foundation.layout.WindowInsetsSides.Companion.Top
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.only
import androidx.compose.foundation.layout.systemBars
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ExpandMore
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.esm.jetsnack_clone.R
import com.esm.jetsnack_clone.ui.LocalNavAnimatedVisibilityScope
import com.esm.jetsnack_clone.ui.LocalSharedTransitionScope
import com.esm.jetsnack_clone.ui.components.JetsnackDivider
import com.esm.jetsnack_clone.ui.components.JetsnackPreviewWrapper
import com.esm.jetsnack_clone.ui.snackdetail.spatialExpressiveSpring
import com.esm.jetsnack_clone.ui.theme.AlphaNearOpaque
import com.esm.jetsnack_clone.ui.theme.JetsnackTheme
import com.esm.jetsnack_clone.ui.utils.safeAnimateEnterExit
import com.esm.jetsnack_clone.ui.utils.safeRenderInSharedTransitionScopeOverlay
import java.lang.IllegalStateException

@Composable
fun DestinationBar(modifier: Modifier = Modifier) {
   /* val sharedElementScope =
        LocalSharedTransitionScope.current ?: throw IllegalStateException("No shared element scope")
    val navAnimatedScope =
        LocalNavAnimatedVisibilityScope.current ?: throw IllegalStateException("No nav scope")*/
 /*   with(sharedElementScope) {
        with(navAnimatedScope) {*/
            Column(
                modifier = modifier
                    .safeRenderInSharedTransitionScopeOverlay()
                    .safeAnimateEnterExit(
                        enter = slideInVertically(spatialExpressiveSpring()) { -it },
                        exit = slideOutVertically(spatialExpressiveSpring()) { -it }
                    )
            ) {
                TopAppBar(
                    backgroundColor = JetsnackTheme.colors.uiBackground
                        .copy(alpha = AlphaNearOpaque),
                    contentColor = JetsnackTheme.colors.textSecondary,
                    contentPadding = WindowInsets.systemBars.only(Horizontal + Top)
                        .asPaddingValues(),
                    elevation = 0.dp,
                ) {
                    Text(
                        text = "Delivery to 1600 Amphitheater Way",
                        style = MaterialTheme.typography.subtitle1,
                        color = JetsnackTheme.colors.textSecondary,
                        textAlign = TextAlign.Center,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis,
                        modifier = Modifier
                            .weight(1f)
                            .align(Alignment.CenterVertically)
                    )
                    IconButton(
                        onClick = { /* todo */ },
                        modifier = Modifier.align(Alignment.CenterVertically)
                    ) {
                        Icon(
                            imageVector = Icons.Outlined.ExpandMore,
                            tint = JetsnackTheme.colors.brand,
                            contentDescription = stringResource(R.string.label_select_delivery)
                        )
                    }
                }
                JetsnackDivider()
            }
      /*  }
    }*/
}

@Preview("default")
@Preview("dark theme", uiMode = Configuration.UI_MODE_NIGHT_YES)
@Preview("large font", fontScale = 2f)
@Composable
fun PreviewDestinationBar() {
    JetsnackPreviewWrapper {
        DestinationBar()
    }
}
