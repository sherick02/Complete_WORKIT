package com.kanad.workit.data.common

import com.kanad.workit.data.model.WorkoutModel
import com.kanad.workit.data.model.ExerciseModel
import java.util.ArrayList

object Constants {
    const val MY_PREFS = "MyPrefs"

    /** Indicates weather the kotlin compiler should generate getters/setters for this property or not.
    If its set then it will not generate getters/setters for this property . */


    @JvmField
    var days_selected = ArrayList<Int>()

    @JvmField
    var workoutModelArrayList = ArrayList<WorkoutModel>()

    @JvmField
    var exerciseModelArrayList = ArrayList<ExerciseModel>()
}