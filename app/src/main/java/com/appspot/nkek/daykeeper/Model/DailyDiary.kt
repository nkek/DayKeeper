package com.appspot.nkek.daykeeper.Model

/**
 * Created by nkek on 2017. 10. 3..
 */
class DailyDiary constructor(diaryTitle: String, diaryContents: String, diataDate: Long){
    constructor(diaryTitle: String, diaryContents: String, diataDate: Long, weather: String) : this(diaryTitle, diaryContents, diataDate)
}