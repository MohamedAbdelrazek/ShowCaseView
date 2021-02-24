/*
 * Copyright (c) 2018. Faruk Toptaş
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package me.toptas.fancyshowcasesample

import android.graphics.Color
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_queue.*
import me.toptas.fancyshowcase.FancyShowCaseQueue
import me.toptas.fancyshowcase.FancyShowCaseView
import me.toptas.fancyshowcase.listener.OnCompleteListener
import me.toptas.fancyshowcase.listener.SkipListener


class QueueActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_queue)

        val queue = FancyShowCaseQueue()
        val fancyShowCaseView1 = FancyShowCaseView.Builder(this)
                .title("First Queue Item ")
                .titleColor(Color.BLUE)
                .titleSize(32)
                .descriptionSize(18)
                .skipSize(22)
                .descriptionColor(Color.BLACK)
                .skipColor(Color.CYAN)
                .description("First Queue Item First Queue Item eue Item Firstemt Queue Item Firstem First Queue Item First Queue Item First Queue Item First Queue Item First Queue Item")
                .skipTitle("skip")
                .skipListener(object : SkipListener {
                    override fun onSkippTitlePressed() {
                        queue.cancel()
                    }


                })
                .backgroundColor(Color.RED)
                .focusBorderColor(Color.BLACK)
                .focusOn(btn_queue_1)
                .build()


        val fancyShowCaseView2 = FancyShowCaseView.Builder(this)
                .title("Second Queue Item")
                .skipTitle("finish")
                .skipListener(object : SkipListener {
                    override fun onSkippTitlePressed() {
                        queue.cancel()
                    }
                })
                .focusOn(btn_queue_2)
                .build()

        val fancyShowCaseView3 = FancyShowCaseView.Builder(this)
                .title("Third Queue Item")
                .focusOn(btn_queue_3)
                .build()

        queue.add(fancyShowCaseView1)
                .add(fancyShowCaseView2)
                .add(fancyShowCaseView3)
        queue.show()


        queue.completeListener = object : OnCompleteListener {
            override fun onComplete() {
                Toast.makeText(this@QueueActivity, "Finished", Toast.LENGTH_SHORT).show()
            }
        }

    }
}
