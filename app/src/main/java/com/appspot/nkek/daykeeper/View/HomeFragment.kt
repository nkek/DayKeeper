package com.appspot.nkek.daykeeper.View


import android.content.Context
import android.graphics.Color
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import com.appspot.nkek.daykeeper.R
import java.util.*
import android.widget.GridView
import kotlinx.android.synthetic.main.fragment_home_layout.view.*
import java.text.SimpleDateFormat


/**
 * Created by nkek on 2018. 2. 16..
 */
class HomeFragment: Fragment() {

    private var gridAdapter: GridAdapter ?= null
    private var dayList: ArrayList<String> ?= null
    private var mContext: Context ?= null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        return  inflater.inflate(R.layout.fragment_home_layout, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mContext = activity

        // 오늘에 날짜를 세팅 해준다.

        val now = System.currentTimeMillis()

        val date = Date(now)

        //연,월,일을 따로 저장

        val curYearFormat = SimpleDateFormat("yyyy", Locale.KOREA)

        val curMonthFormat = SimpleDateFormat("MM", Locale.KOREA)

        val curDayFormat = SimpleDateFormat("dd", Locale.KOREA)


        //현재 날짜 텍스트뷰에 뿌려줌

        view.tv_date.setText(curYearFormat.format(date) + "/" + curMonthFormat.format(date))


        //gridview 요일 표시

        dayList = ArrayList()

        dayList?.add("일")

        dayList?.add("월")

        dayList?.add("화")

        dayList?.add("수")

        dayList?.add("목")

        dayList?.add("금")

        dayList?.add("토")

        Calendar.getInstance().set(Integer.parseInt(curYearFormat.format(date)), Integer.parseInt(curMonthFormat.format(date)) - 1, 1)

        val dayNum = Calendar.getInstance().get(Calendar.DAY_OF_WEEK)

        //1일 - 요일 매칭 시키기 위해 공백 add

        for (i in 1 until dayNum) {

            dayList?.add("")

        }

        setCalendarDate(Calendar.getInstance().get(Calendar.MONTH) + 1)



        gridAdapter = GridAdapter(mContext!!, dayList!!)

        view.calGridview.setAdapter(gridAdapter)
    }

    private fun setCalendarDate(month: Int){
        Calendar.getInstance().set(Calendar.MONTH, month - 1)
        for (i in 0 until Calendar.getInstance().getActualMaximum(Calendar.DAY_OF_MONTH)) {
            dayList?.add("" + (i + 1))
        }
    }


    private class GridAdapter constructor(context: Context, list: List<String>): BaseAdapter(){
        private var mList: List<String> = list
        private var mInflater: LayoutInflater ?= null

        init {
            this.mInflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

        }
        override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
            var holder: ViewHolder
            var v: View ?= convertView
            if(v == null){
                v = mInflater?.inflate(R.layout.item_calendar_gridview, parent, false)
                holder = ViewHolder()
                holder.tvItemGridView = v?.findViewById(R.id.tvItemGridView) as TextView

                v?.tag = holder
            }else{
                holder = convertView?.tag as ViewHolder
            }
            holder.tvItemGridView.text = "" + getItem(position)


            val today = Calendar.getInstance().get(Calendar.DAY_OF_MONTH)

            val sToday = today.toString()

            if (sToday == getItem(position)) { //오늘 day 텍스트 컬러 변경
                holder.tvItemGridView.setTextColor(Color.BLACK)

            }

            return v
        }

        override fun getItem(position: Int): Any {
            return mList.get(position)
        }

        override fun getItemId(position: Int): Long {
            return position.toLong()
        }

        override fun getCount(): Int {
            return mList.size
        }
    }

    private class ViewHolder {
        lateinit var tvItemGridView: TextView
    }
}