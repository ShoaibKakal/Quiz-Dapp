package com.example.quizdapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.quizdapp.data.Question

class QuestionsAdapter(val questions: ArrayList<Question>) :
    RecyclerView.Adapter<QuestionsAdapter.QuestionVH>() {
    class QuestionVH(view: View) : RecyclerView.ViewHolder(view) {

        private val tvQuestion = view.findViewById<TextView>(R.id.tv_question)
        private val layoutOptionA = view.findViewById<LinearLayout>(R.id.option_a_layout)
        private val layoutOptionB = view.findViewById<LinearLayout>(R.id.option_b_layout)
        private val tvQno = view.findViewById<TextView>(R.id.tvId)
        private val context = view.context


        fun bindData(question: Question, index: Int) {

            tvQuestion.text = question.question
            tvQno.text = "Question: 0${index + 1}"


            layoutOptionB.background =
                context.resources.getDrawable(R.drawable.options_unselected_background_drawable)
            layoutOptionA.background =
                context.resources.getDrawable(R.drawable.options_unselected_background_drawable)


            layoutOptionA.setOnClickListener {
                layoutOptionB.background =
                    context.resources.getDrawable(R.drawable.options_unselected_background_drawable)

                if (question.`true`) {
                    layoutOptionA.background =
                        context.resources.getDrawable(R.drawable.option_correct_selected_background_drawable)

                } else {
                    layoutOptionA.background =
                        context.resources.getDrawable(R.drawable.option_wrong_selected_background_drawable)

                }
            }

            layoutOptionB.setOnClickListener {
                layoutOptionA.background =
                    context.resources.getDrawable(R.drawable.options_unselected_background_drawable)

                if (!question.`true`) {
                    layoutOptionB.background =
                        context.resources.getDrawable(R.drawable.option_correct_selected_background_drawable)
                } else {
                    layoutOptionB.background =
                        context.resources.getDrawable(R.drawable.option_wrong_selected_background_drawable)

                }
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): QuestionVH {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_question_layout, parent, false)
        return QuestionVH(view)
    }

    override fun onBindViewHolder(holder: QuestionVH, position: Int) {
        holder.bindData(questions[position], position)
    }

    override fun getItemCount(): Int {
        return questions.size
    }
}