package com.appspot.nkek.daykeeper.Model

/**
 * Created by nkek on 2017. 10. 3..
 */
class DailyDiary constructor(diaryID: Int, diaryTitle: String, diaryContents: String, diataDate: Long){
    constructor(diaryID: Int,diaryTitle: String, diaryContents: String, diataDate: Long, weather: String) : this(diaryID, diaryTitle, diaryContents, diataDate)
}