package com.dinislam.svodkaandroidversion

import android.content.Context
import android.os.Bundle
import android.util.DisplayMetrics
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.dinislam.svodkaandroidversion.data.DGU
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.additional_field_today.*
import kotlinx.android.synthetic.main.additional_field_tomorrow.*
import kotlinx.android.synthetic.main.main_field_today.*
import kotlinx.android.synthetic.main.main_field_tomorrow.*
import kotlinx.android.synthetic.main.panel_remains.*
import java.text.SimpleDateFormat
import java.util.*


class MainActivity : AppCompatActivity() {
    private val arrayToday = arrayListOf<DGU>()
    private val arrayAdditionalToday = arrayListOf<EditText>()
    private val arrayTomorrow = arrayListOf<DGU>()
    private val arrayAdditionalTomorrow = arrayListOf<EditText>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.i("Den", getScreenSize().toString())
        try {
            if(getScreenSize() > 1200){
                setContentView(R.layout.activity_main)
            } else setContentView(R.layout.activity_main_small_size)
            initArray()
            formattingData()
        } catch (e: Exception){
            Toast.makeText(this, "Ошибка", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i("Den", "destroy")

    }

    private fun getScreenSize(): Int {
        val displayMetrics = DisplayMetrics()
        windowManager.defaultDisplay.getMetrics(displayMetrics)
        val a = if (displayMetrics.widthPixels < displayMetrics.heightPixels)  displayMetrics.heightPixels else displayMetrics.widthPixels
        return (a / displayMetrics.density).toInt()
    }

    private fun initArray() {
        // Additional field today
        arrayAdditionalToday.add(edit_text_additionFuel)
        arrayAdditionalToday.add(editText_additionOil)
        arrayAdditionalToday.add(editText_allTanksOfDGU)
        arrayAdditionalToday.add(edit_text_cistern1)
        arrayAdditionalToday.add(edit_text_cistern2)
        arrayAdditionalToday.add(edit_text_cistern3)
        arrayAdditionalToday.add(edit_text_cistern4)
        arrayAdditionalToday.add(edit_text_cistern5)
        arrayAdditionalToday.add(edit_text_cistern6)
        arrayAdditionalToday.add(edit_text_cistern7)
        arrayAdditionalToday.add(editText_densityFuel)
        arrayAdditionalToday.add(editText_DGU_coefficient_transformation_field_today)
        arrayAdditionalToday.add(editText_driller_coefficient_transformation_field_today)
        arrayAdditionalToday.add(editText_activeEnDrilling_today)
        arrayAdditionalToday.add(editText_activeEnDrilling_today)
        arrayAdditionalToday.add(editText_reactiveEnDrilling_today)

        val dgu1 = DGU()
        dgu1.prop01 = textView_today_day_engineHours
        dgu1.prop02 = editText_all_engineHours_today
        dgu1.prop03 = textView_day_KWT_today
        dgu1.prop04 = editText_all_KWT_today
        dgu1.prop05 = textView_averageLoad_today
        dgu1.prop06 = textView_fuelConsumption_today
        dgu1.prop07 = editText_coefficient_today
        dgu1.prop08 = editText_oilConsumption_today
        dgu1.prop09 = editText_afterServiceTO_today
        dgu1.prop10 = editText_activeEnergy_today
        dgu1.prop11 = editText_reactiveEnergy_today
        dgu1.prop12 = textView_KWT_today
        dgu1.prop13 = textView_differenceInKWT_today
        arrayToday.add(dgu1)

        val dgu2 = DGU()
        dgu2.prop01 = textView_engineHours_DGU2_today
        dgu2.prop02 = editText_allEngineHours_DGU2_today
        dgu2.prop03 = textView_dayKWT_DGU2_today
        dgu2.prop04 = editText_allKWT_DGU2_today
        dgu2.prop05 = textView_averageLoad_DGU2_today
        dgu2.prop06 = editText_fuelConsumption_DGU2_today
        dgu2.prop07 = editText_coefficient_DGU2_today
        dgu2.prop08 = editText_oilConsumption_DGU2_today
        dgu2.prop09 = editText_afterServiceTO_DGU2_today
        dgu2.prop10 = editText_activeEnergy_DGU2_today
        dgu2.prop11 = editText_reactiveEnergy_DGU2_today
        dgu2.prop12 = textView_KWT_DGU2_today
        dgu2.prop13 = textView_differenceInKWT_DGU2_today
        arrayToday.add(dgu2)

        val dgu3 = DGU()
        dgu3.prop01 =      textView_engineHours_DGU3_today
        dgu3.prop02 =   editText_allEngineHours_DGU3_today
        dgu3.prop03 =           textView_dayKWT_DGU3_today
        dgu3.prop04 =           editText_allKWT_DGU3_today
        dgu3.prop05 =      textView_averageLoad_DGU3_today
        dgu3.prop06 =  editText_fuelConsumption_DGU3_today
        dgu3.prop07 =      editText_coefficient_DGU3_today
        dgu3.prop08 =   editText_oilConsumption_DGU3_today
        dgu3.prop09 =   editText_afterServiceTO_DGU3_today
        dgu3.prop10 =     editText_activeEnergy_DGU3_today
        dgu3.prop11 =   editText_reactiveEnergy_DGU3_today
        dgu3.prop12 =              textView_KWT_DGU3_today
        dgu3.prop13 =  textView_differenceInKWT_DGU3_today
        arrayToday.add(dgu3)


        val dgu4 = DGU()
        dgu4.prop01 =      textView_engineHours_DGU4_today
        dgu4.prop02 =   editText_allEngineHours_DGU4_today
        dgu4.prop03 =           textView_dayKWT_DGU4_today
        dgu4.prop04 =           editText_allKWT_DGU4_today
        dgu4.prop05 =      textView_averageLoad_DGU4_today
        dgu4.prop06 =  editText_fuelConsumption_DGU4_today
        dgu4.prop07 =      editText_coefficient_DGU4_today
        dgu4.prop08 =   editText_oilConsumption_DGU4_today
        dgu4.prop09 =   editText_afterServiceTO_DGU4_today
        dgu4.prop10 =     editText_activeEnergy_DGU4_today
        dgu4.prop11 =   editText_reactiveEnergy_DGU4_today
        dgu4.prop12 =              textView_KWT_DGU4_today
        dgu4.prop13 =  textView_differenceInKWT_DGU4_today
        arrayToday.add(dgu4)



        val dgu5 = DGU()
        dgu5.prop01 =      textView_engineHours_DGU5_today
        dgu5.prop02 =   editText_allEngineHours_DGU5_today
        dgu5.prop03 =           textView_dayKWT_DGU5_today
        dgu5.prop04 =           editText_allKWT_DGU5_today
        dgu5.prop05 =      textView_averageLoad_DGU5_today
        dgu5.prop06 =  editText_fuelConsumption_DGU5_today
        dgu5.prop07 =      editText_coefficient_DGU5_today
        dgu5.prop08 =   editText_oilConsumption_DGU5_today
        dgu5.prop09 =   editText_afterServiceTO_DGU5_today
        dgu5.prop10 =     editText_activeEnergy_DGU5_today
        dgu5.prop11 =   editText_reactiveEnergy_DGU5_today
        dgu5.prop12 =              textView_KWT_DGU5_today
        dgu5.prop13 =  textView_differenceInKWT_DGU5_today
        arrayToday.add(dgu5)


        val dgu6 = DGU()
        dgu6.prop01 =      textView_engineHours_DGU6_today
        dgu6.prop02 =   editText_allEngineHours_DGU6_today
        dgu6.prop03 =           textView_dayKWT_DGU6_today
        dgu6.prop04 =           editText_allKWT_DGU6_today
        dgu6.prop05 =      textView_averageLoad_DGU6_today
        dgu6.prop06 =  editText_fuelConsumption_DGU6_today
        dgu6.prop07 =      editText_coefficient_DGU6_today
        dgu6.prop08 =   editText_oilConsumption_DGU6_today
        dgu6.prop09 =   editText_afterServiceTO_DGU6_today
        dgu6.prop10 =     editText_activeEnergy_DGU6_today
        dgu6.prop11 =   editText_reactiveEnergy_DGU6_today
        dgu6.prop12 =              textView_KWT_DGU6_today
        dgu6.prop13 =  textView_differenceInKWT_DGU6_today
        arrayToday.add(dgu6)

        val dgu7 = DGU()
        dgu7.prop01 =      textView_engineHours_DGU7_today
        dgu7.prop02 =   editText_allEngineHours_DGU7_today
        dgu7.prop03 =           textView_dayKWT_DGU7_today
        dgu7.prop04 =           editText_allKWT_DGU7_today
        dgu7.prop05 =      textView_averageLoad_DGU7_today
        dgu7.prop06 =  editText_fuelConsumption_DGU7_today
        dgu7.prop07 =      editText_coefficient_DGU7_today
        dgu7.prop08 =   editText_oilConsumption_DGU7_today
        dgu7.prop09 =   editText_afterServiceTO_DGU7_today
        dgu7.prop10 =     editText_activeEnergy_DGU7_today
        dgu7.prop11 =   editText_reactiveEnergy_DGU7_today
        dgu7.prop12 =              textView_KWT_DGU7_today
        dgu7.prop13 =  textView_differenceInKWT_DGU7_today
        arrayToday.add(dgu7)


        val dgu8 = DGU()
        dgu8.prop01 =      textView_engineHours_DGU8_today
        dgu8.prop02 =   editText_allEngineHours_DGU8_today
        dgu8.prop03 =           textView_dayKWT_DGU8_today
        dgu8.prop04 =           editText_allKWT_DGU8_today
        dgu8.prop05 =      textView_averageLoad_DGU8_today
        dgu8.prop06 =  editText_fuelConsumption_DGU8_today
        dgu8.prop07 =      editText_coefficient_DGU8_today
        dgu8.prop08 =   editText_oilConsumption_DGU8_today
        dgu8.prop09 =   editText_afterServiceTO_DGU8_today
        dgu8.prop10 =     editText_activeEnergy_DGU8_today
        dgu8.prop11 =   editText_reactiveEnergy_DGU8_today
        dgu8.prop12 =              textView_KWT_DGU8_today
        dgu8.prop13 =  textView_differenceInKWT_DGU8_today
        arrayToday.add(dgu8)

        //Tomorrow Array initialization
        val dguT1 = DGU()
        dguT1.prop01 = textView_day_engineHours_tomorrow
        dguT1.prop02 = editText_all_engineHours_tomorrow
        dguT1.prop03 = textView_day_KWT
        dguT1.prop04 = editText_all_KWT
        dguT1.prop05 = textView_averageLoad
        dguT1.prop06 = editText_fuelConsumption
        dguT1.prop07 = editText_coefficient
        dguT1.prop08 = editText_oilConsumption
        dguT1.prop09 = editText_afterServiceTO
        dguT1.prop10 = editText_activeEnergy
        dguT1.prop11 = editText_reactiveEnergy
        dguT1.prop12 = textView_KWT_second_counter
        dguT1.prop13 = textView_differenceInKWT
        arrayTomorrow.add(dguT1)

        val dguT2 = DGU()
        dguT2.prop01 =     textView_engineHours_DGU2
        dguT2.prop02 =  editText_allEngineHours_DGU2
        dguT2.prop03 =          textView_dayKWT_DGU2
        dguT2.prop04 =          editText_allKWT_DGU2
        dguT2.prop05 =     textView_averageLoad_DGU2
        dguT2.prop06 = editText_fuelConsumption_DGU2
        dguT2.prop07 =     editText_coefficient_DGU2
        dguT2.prop08 =  editText_oilConsumption_DGU2
        dguT2.prop09 =  editText_afterServiceTO_DGU2
        dguT2.prop10 =    editText_activeEnergy_DGU2
        dguT2.prop11 =  editText_reactiveEnergy_DGU2
        dguT2.prop12 =             textView_KWT_DGU2
        dguT2.prop13 = textView_differenceInKWT_DGU2
        arrayTomorrow.add(dguT2)

        val dguT3 = DGU()
        dguT3.prop01 =     textView_engineHours_DGU3
        dguT3.prop02 =  editText_allEngineHours_DGU3
        dguT3.prop03 =          textView_dayKWT_DGU3
        dguT3.prop04 =          editText_allKWT_DGU3
        dguT3.prop05 =     textView_averageLoad_DGU3
        dguT3.prop06 = editText_fuelConsumption_DGU3
        dguT3.prop07 =     editText_coefficient_DGU3
        dguT3.prop08 =  editText_oilConsumption_DGU3
        dguT3.prop09 =  editText_afterServiceTO_DGU3
        dguT3.prop10 =    editText_activeEnergy_DGU3
        dguT3.prop11 =  editText_reactiveEnergy_DGU3
        dguT3.prop12 =             textView_KWT_DGU3
        dguT3.prop13 = textView_differenceInKWT_DGU3
        arrayTomorrow.add(dguT3)

        val dguT4 = DGU()
        dguT4.prop01 =     textView_engineHours_DGU4
        dguT4.prop02 =  editText_allEngineHours_DGU4
        dguT4.prop03 =          textView_dayKWT_DGU4
        dguT4.prop04 =          editText_allKWT_DGU4
        dguT4.prop05 =     textView_averageLoad_DGU4
        dguT4.prop06 = editText_fuelConsumption_DGU4
        dguT4.prop07 =     editText_coefficient_DGU4
        dguT4.prop08 =  editText_oilConsumption_DGU4
        dguT4.prop09 =  editText_afterServiceTO_DGU4
        dguT4.prop10 =    editText_activeEnergy_DGU4
        dguT4.prop11 =  editText_reactiveEnergy_DGU4
        dguT4.prop12 =             textView_KWT_DGU4
        dguT4.prop13 = textView_differenceInKWT_DGU4
        arrayTomorrow.add(dguT4)

        val dguT5 = DGU()
        dguT5.prop01 =     textView_engineHours_DGU5
        dguT5.prop02 =  editText_allEngineHours_DGU5
        dguT5.prop03 =          textView_dayKWT_DGU5
        dguT5.prop04 =          editText_allKWT_DGU5
        dguT5.prop05 =     textView_averageLoad_DGU5
        dguT5.prop06 = editText_fuelConsumption_DGU5
        dguT5.prop07 =     editText_coefficient_DGU5
        dguT5.prop08 =  editText_oilConsumption_DGU5
        dguT5.prop09 =  editText_afterServiceTO_DGU5
        dguT5.prop10 =    editText_activeEnergy_DGU5
        dguT5.prop11 =  editText_reactiveEnergy_DGU5
        dguT5.prop12 =             textView_KWT_DGU5
        dguT5.prop13 = textView_differenceInKWT_DGU5
        arrayTomorrow.add(dguT5)

        val dguT6 = DGU()
        dguT6.prop01 =     textView_engineHours_DGU6
        dguT6.prop02 =  editText_allEngineHours_DGU6
        dguT6.prop03 =          textView_dayKWT_DGU6
        dguT6.prop04 =          editText_allKWT_DGU6
        dguT6.prop05 =     textView_averageLoad_DGU6
        dguT6.prop06 = editText_fuelConsumption_DGU6
        dguT6.prop07 =     editText_coefficient_DGU6
        dguT6.prop08 =  editText_oilConsumption_DGU6
        dguT6.prop09 =  editText_afterServiceTO_DGU6
        dguT6.prop10 =    editText_activeEnergy_DGU6
        dguT6.prop11 =  editText_reactiveEnergy_DGU6
        dguT6.prop12 =             textView_KWT_DGU6
        dguT6.prop13 = textView_differenceInKWT_DGU6
        arrayTomorrow.add(dguT6)

        val dguT7 = DGU()
        dguT7.prop01 =     textView_engineHours_DGU7
        dguT7.prop02 =  editText_allEngineHours_DGU7
        dguT7.prop03 =          textView_dayKWT_DGU7
        dguT7.prop04 =          editText_allKWT_DGU7
        dguT7.prop05 =     textView_averageLoad_DGU7
        dguT7.prop06 = editText_fuelConsumption_DGU7
        dguT7.prop07 =     editText_coefficient_DGU7
        dguT7.prop08 =  editText_oilConsumption_DGU7
        dguT7.prop09 =  editText_afterServiceTO_DGU7
        dguT7.prop10 =    editText_activeEnergy_DGU7
        dguT7.prop11 =  editText_reactiveEnergy_DGU7
        dguT7.prop12 =             textView_KWT_DGU7
        dguT7.prop13 = textView_differenceInKWT_DGU7
        arrayTomorrow.add(dguT7)

        val dguT8 = DGU()
        dguT8.prop01 =     textView_engineHours_DGU8
        dguT8.prop02 =  editText_allEngineHours_DGU8
        dguT8.prop03 =          textView_dayKWT_DGU8
        dguT8.prop04 =          editText_allKWT_DGU8
        dguT8.prop05 =     textView_averageLoad_DGU8
        dguT8.prop06 = editText_fuelConsumption_DGU8
        dguT8.prop07 =     editText_coefficient_DGU8
        dguT8.prop08 =  editText_oilConsumption_DGU8
        dguT8.prop09 =  editText_afterServiceTO_DGU8
        dguT8.prop10 =    editText_activeEnergy_DGU8
        dguT8.prop11 =  editText_reactiveEnergy_DGU8
        dguT8.prop12 =             textView_KWT_DGU8
        dguT8.prop13 = textView_differenceInKWT_DGU8
        arrayTomorrow.add(dguT8)

        // Additional field tomorrow
        arrayAdditionalTomorrow.add(editText_remainingFuel)
        arrayAdditionalTomorrow.add(editText_remainingOil)
        arrayAdditionalTomorrow.add(editText_fuelCounter)
        arrayAdditionalTomorrow.add(editText_activeEnDrilling)
        arrayAdditionalTomorrow.add(editText_reactiveEnDrilling)
        arrayAdditionalTomorrow.add(editText_activeSpare)
        arrayAdditionalTomorrow.add(editText_reactiveSpare)
    }

    private fun saveData() : Boolean{
        for (dg in arrayToday){
            if(edit_text_allEngineRunHoursOfComplex.text.toString() == "0" || edit_text_allEngineRunHoursOfComplex.text.isEmpty()){
                Toast.makeText(this, "Отсутствуют данные работы энергокомплекса. Сводка не сохранена.",
                    Toast.LENGTH_SHORT).show()
                return false
            }
        }

        val mainFieldSb = StringBuilder()
        for (e in arrayToday){
            mainFieldSb.append(e.prop01.text.toString().plus(";"))
            mainFieldSb.append(e.prop02.text.toString().plus(";"))
            mainFieldSb.append(e.prop03.text.toString().plus(";"))
            mainFieldSb.append(e.prop04.text.toString().plus(";"))
            mainFieldSb.append(e.prop05.text.toString().plus(";"))
            mainFieldSb.append(e.prop06.text.toString().plus(";"))
            mainFieldSb.append(e.prop07.text.toString().plus(";"))
            mainFieldSb.append(e.prop08.text.toString().plus(";"))
            mainFieldSb.append(e.prop09.text.toString().plus(";"))
            mainFieldSb.append(e.prop10.text.toString().plus(";"))
            mainFieldSb.append(e.prop11.text.toString().plus(";"))
            mainFieldSb.append(e.prop12.text.toString().plus(";"))
            mainFieldSb.append(e.prop13.text.toString().plus(";"))

        }
        val additionalFieldSB = StringBuilder()
        additionalFieldSB.append(editText_remainingFuel_today.text.toString().plus(";"))
        additionalFieldSB.append(edit_text_remainingOil_today.text.toString().plus(";"))
        additionalFieldSB.append(edit_text_fuelCounter_today.text.toString().plus(";"))
        additionalFieldSB.append(editText_activeEnDrilling_today.text.toString().plus(";"))
        additionalFieldSB.append(editText_reactiveEnDrilling_today.text.toString().plus(";"))
        additionalFieldSB.append(editText_DGU_coefficient_transformation_field_today.text.toString().plus(";"))
        additionalFieldSB.append(editText_driller_coefficient_transformation_field_today.text.toString().plus(";"))

        val remainsPanelSB = StringBuilder()
        remainsPanelSB.append(edit_text_cistern1.text.toString().plus(";"))
        remainsPanelSB.append(edit_text_cistern2.text.toString().plus(";"))
        remainsPanelSB.append(edit_text_cistern3.text.toString().plus(";"))
        remainsPanelSB.append(edit_text_cistern4.text.toString().plus(";"))
        remainsPanelSB.append(edit_text_cistern5.text.toString().plus(";"))
        remainsPanelSB.append(edit_text_cistern6.text.toString().plus(";"))
        remainsPanelSB.append(edit_text_cistern7.text.toString().plus(";"))
        remainsPanelSB.append(editText_densityFuel.text.toString().plus(";"))
        remainsPanelSB.append(editText_allTanksOfDGU.text.toString().plus(";"))

        val sharedPref = this?.getPreferences(Context.MODE_PRIVATE) ?: return false
        with (sharedPref.edit()) {
            putString(getString(R.string.save_main_field), mainFieldSb.toString())
            putString(getString(R.string.save_additional_field), additionalFieldSB.toString())
            putString(getString(R.string.save_remains_field), remainsPanelSB.toString())
            putString(getString(R.string.save_notes_field), editText_notes.text.toString())
            commit()
            return true
        }
    }  private fun restoreData(){
        val sharedPref = this?.getPreferences(Context.MODE_PRIVATE) ?: return
        val mainInf = sharedPref.getString(getString(R.string.save_main_field), "0")
        val additionalInf = sharedPref.getString(getString(R.string.save_additional_field), "0")
        val remInf = sharedPref.getString(getString(R.string.save_remains_field), "0")
        val notesInf = sharedPref.getString(getString(R.string.save_notes_field), "0")
        Log.i("Den", mainInf)
        Log.i("Den", additionalInf)
        Log.i("Den", remInf)
        Log.i("Den", notesInf)
        var mainInfArray = mainInf?.split(";")
        val additionalInfArray = additionalInf?.split(";")
        val remInfArr = remInf?.split(";")

        var i = 0;

        if(mainInfArray?.size!!  < 2){
            Toast.makeText(this, "Ошибка восстановления сводки. Данные отсутсвуют", Toast.LENGTH_SHORT).show()
            return
        }


        for ( e in arrayToday){
            e.prop01.setText(mainInfArray?.get(i) ?: "0")
            e.prop02.setText(mainInfArray?.get(i + 1) ?: "0" )
            e.prop03.setText(mainInfArray?.get(i + 2) ?: "0" )
            e.prop04.setText(mainInfArray?.get(i + 3) ?: "0" )
            e.prop05.setText(mainInfArray?.get(i + 4) ?: "0" )
            e.prop06.setText(mainInfArray?.get(i + 5) ?: "0" )
            e.prop07.setText(mainInfArray?.get(i + 6) ?: "0" )
            e.prop08.setText(mainInfArray?.get(i + 7) ?: "0" )
            e.prop09.setText(mainInfArray?.get(i + 8) ?: "0" )
            e.prop10.setText(mainInfArray?.get(i + 9) ?: "0" )
            e.prop11.setText(mainInfArray?.get(i + 10) ?: "0" )
            e.prop12.setText(mainInfArray?.get(i + 11) ?: "0" )
            e.prop13.setText(mainInfArray?.get(i + 12) ?: "0" )
            i +=13
        }
        i = 0
        for ( e in arrayTomorrow){
            e.prop01.setText(mainInfArray?.get(i) ?: "0")
            e.prop02.setText(mainInfArray?.get(i + 1) ?: "0" )
            e.prop03.setText(mainInfArray?.get(i + 2) ?: "0" )
            e.prop04.setText(mainInfArray?.get(i + 3) ?: "0" )
            e.prop05.setText(mainInfArray?.get(i + 4) ?: "0" )
            e.prop06.setText(mainInfArray?.get(i + 5) ?: "0" )
            e.prop07.setText(mainInfArray?.get(i + 6) ?: "0" )
            e.prop08.setText(mainInfArray?.get(i + 7) ?: "0" )
            e.prop09.setText(mainInfArray?.get(i + 8) ?: "0" )
            e.prop10.setText(mainInfArray?.get(i + 9) ?: "0" )
            e.prop11.setText(mainInfArray?.get(i + 10) ?: "0" )
            e.prop12.setText(mainInfArray?.get(i + 11) ?: "0" )
            e.prop13.setText(mainInfArray?.get(i + 12) ?: "0" )
            i +=13
        }

        // Заполнение вчерашний полей
        editText_remainingFuel.setText(     additionalInfArray?.get(0).toString() ?: "0")
        editText_remainingOil.setText(      additionalInfArray?.get(1).toString() ?: "0")
        editText_fuelCounter.setText(       additionalInfArray?.get(2).toString() ?: "0")
        editText_activeEnDrilling.setText(  additionalInfArray?.get(3).toString() ?: "0")
        editText_activeEnDrilling_today.setText(  additionalInfArray?.get(3).toString() ?: "0")
        editText_reactiveEnDrilling.setText(additionalInfArray?.get(4).toString() ?: "0")
        editText_reactiveEnDrilling_today.setText(additionalInfArray?.get(4).toString() ?: "0")

        //Проставление сегодняшних кэфов трансформации
        editText_DGU_coefficient_transformation_field_today.setText(additionalInfArray?.get(5).toString() ?: "0")
        editText_driller_coefficient_transformation_field_today.setText(additionalInfArray?.get(6).toString() ?: "0")

        //Панель остатков
        edit_text_cistern1.setText(    remInfArr?.get(0).toString() ?: "0")
        edit_text_cistern2.setText(    remInfArr?.get(1).toString() ?: "0")
        edit_text_cistern3.setText(    remInfArr?.get(2).toString() ?: "0")
        edit_text_cistern4.setText(    remInfArr?.get(3).toString() ?: "0")
        edit_text_cistern5.setText(    remInfArr?.get(4).toString() ?: "0")
        edit_text_cistern6.setText(    remInfArr?.get(5).toString() ?: "0")
        edit_text_cistern7.setText(    remInfArr?.get(6).toString() ?: "0")
        editText_densityFuel.setText(  remInfArr?.get(7).toString() ?: "0")
        editText_allTanksOfDGU.setText(remInfArr?.get(8).toString() ?: "0")

        // Заметки
        editText_notes.setText(notesInf)
        edit_text_additionFuel.setText("0")
        editText_additionOil.setText("0")

        calculation()

        Toast.makeText(this, "Восстановлено", Toast.LENGTH_SHORT).show();
    }

    private fun calculation(){
        formattingData()
        try {
            //Day Engine Hours of all DGU
            textView_today_day_engineHours.text = (editText_all_engineHours_today.text.toString().toInt() - editText_all_engineHours_tomorrow.text.toString().toInt()).toString()
            textView_engineHours_DGU2_today.text = (editText_allEngineHours_DGU2_today.text.toString().toInt() - editText_allEngineHours_DGU2.text.toString().toInt()).toString()
            textView_engineHours_DGU3_today.text = (editText_allEngineHours_DGU3_today.text.toString().toInt() - editText_allEngineHours_DGU3.text.toString().toInt()).toString()
            textView_engineHours_DGU4_today.text = (editText_allEngineHours_DGU4_today.text.toString().toInt() - editText_allEngineHours_DGU4.text.toString().toInt()).toString()
            textView_engineHours_DGU5_today.text = (editText_allEngineHours_DGU5_today.text.toString().toInt() - editText_allEngineHours_DGU5.text.toString().toInt()).toString()
            textView_engineHours_DGU6_today.text = (editText_allEngineHours_DGU6_today.text.toString().toInt() - editText_allEngineHours_DGU6.text.toString().toInt()).toString()
            textView_engineHours_DGU7_today.text = (editText_allEngineHours_DGU7_today.text.toString().toInt() - editText_allEngineHours_DGU7.text.toString().toInt()).toString()
            textView_engineHours_DGU8_today.text = (editText_allEngineHours_DGU8_today.text.toString().toInt() - editText_allEngineHours_DGU8.text.toString().toInt()).toString()

            // KWT All DGU
            textView_day_KWT_today.text = (editText_all_KWT_today .text.toString().toInt() - editText_all_KWT.text.toString().toInt()).toString()
            textView_dayKWT_DGU2_today.text = (editText_allKWT_DGU2_today.text.toString().toInt() - editText_allKWT_DGU2.text.toString().toInt()).toString()
            textView_dayKWT_DGU3_today.text = (editText_allKWT_DGU3_today.text.toString().toInt() - editText_allKWT_DGU3.text.toString().toInt()).toString()
            textView_dayKWT_DGU4_today.text = (editText_allKWT_DGU4_today.text.toString().toInt() - editText_allKWT_DGU4.text.toString().toInt()).toString()
            textView_dayKWT_DGU5_today.text = (editText_allKWT_DGU5_today.text.toString().toInt() - editText_allKWT_DGU5.text.toString().toInt()).toString()
            textView_dayKWT_DGU6_today.text = (editText_allKWT_DGU6_today.text.toString().toInt() - editText_allKWT_DGU6.text.toString().toInt()).toString()
            textView_dayKWT_DGU7_today.text = (editText_allKWT_DGU7_today.text.toString().toInt() - editText_allKWT_DGU7.text.toString().toInt()).toString()
            textView_dayKWT_DGU8_today.text = (editText_allKWT_DGU8_today.text.toString().toInt() - editText_allKWT_DGU8.text.toString().toInt()).toString()

            // Average Load
            if(textView_day_KWT_today.text.toString().trim().toInt() > 0 && textView_today_day_engineHours.text.toString().trim().toInt() > 0)  textView_averageLoad_today.text = (textView_day_KWT_today.text.toString().toInt() / textView_today_day_engineHours.text.toString().toInt()).toString()
            if(textView_dayKWT_DGU2_today.text.toString().toInt() > 0 && textView_engineHours_DGU2_today.text.toString().toInt() > 0)    textView_averageLoad_DGU2_today.text = (textView_dayKWT_DGU2_today.text.toString().toInt() / textView_engineHours_DGU2_today.text.toString().toInt()).toString()
            if(textView_dayKWT_DGU3_today.text.toString().toInt() > 0 && textView_engineHours_DGU3_today.text.toString().toInt() > 0)    textView_averageLoad_DGU3_today.text = (textView_dayKWT_DGU3_today.text.toString().toInt() / textView_engineHours_DGU3_today.text.toString().toInt()).toString()
            if(textView_dayKWT_DGU4_today.text.toString().toInt() > 0 && textView_engineHours_DGU4_today.text.toString().toInt() > 0)    textView_averageLoad_DGU4_today.text = (textView_dayKWT_DGU4_today.text.toString().toInt() / textView_engineHours_DGU4_today.text.toString().toInt()).toString()
            if(textView_dayKWT_DGU5_today.text.toString().toInt() > 0 && textView_engineHours_DGU5_today.text.toString().toInt() > 0)    textView_averageLoad_DGU5_today.text = (textView_dayKWT_DGU5_today.text.toString().toInt() / textView_engineHours_DGU5_today.text.toString().toInt()).toString()
            if(textView_dayKWT_DGU6_today.text.toString().toInt() > 0 && textView_engineHours_DGU6_today.text.toString().toInt() > 0)    textView_averageLoad_DGU6_today.text = (textView_dayKWT_DGU6_today.text.toString().toInt() / textView_engineHours_DGU6_today.text.toString().toInt()).toString()
            if(textView_dayKWT_DGU7_today.text.toString().toInt() > 0 && textView_engineHours_DGU7_today.text.toString().toInt() > 0)    textView_averageLoad_DGU7_today.text = (textView_dayKWT_DGU7_today.text.toString().toInt() / textView_engineHours_DGU7_today.text.toString().toInt()).toString()
            if(textView_dayKWT_DGU8_today.text.toString().toInt() > 0 && textView_engineHours_DGU8_today.text.toString().toInt() > 0)    textView_averageLoad_DGU8_today.text = (textView_dayKWT_DGU8_today.text.toString().toInt() / textView_engineHours_DGU8_today.text.toString().toInt()).toString()

            //Fuel Consumption
            textView_fuelConsumption_today.setText(((editText_coefficient_today.text.toString().toDouble() / editText_densityFuel.text.toString().toDouble()) * textView_day_KWT_today.text.toString().toInt()).toInt().toString())
            editText_fuelConsumption_DGU2_today.setText(((editText_coefficient_DGU2_today.text.toString().toDouble() / editText_densityFuel.text.toString().toDouble()) * textView_dayKWT_DGU2_today.text.toString().toInt()).toInt().toString())
            editText_fuelConsumption_DGU3_today.setText(((editText_coefficient_DGU3_today.text.toString().toDouble() / editText_densityFuel.text.toString().toDouble()) * textView_dayKWT_DGU3_today.text.toString().toInt()).toInt().toString())
            editText_fuelConsumption_DGU4_today.setText(((editText_coefficient_DGU4_today.text.toString().toDouble() / editText_densityFuel.text.toString().toDouble()) * textView_dayKWT_DGU4_today.text.toString().toInt()).toInt().toString())
            editText_fuelConsumption_DGU5_today.setText(((editText_coefficient_DGU5_today.text.toString().toDouble() / editText_densityFuel.text.toString().toDouble()) * textView_dayKWT_DGU5_today.text.toString().toInt()).toInt().toString())
            editText_fuelConsumption_DGU6_today.setText(((editText_coefficient_DGU6_today.text.toString().toDouble() / editText_densityFuel.text.toString().toDouble()) * textView_dayKWT_DGU6_today.text.toString().toInt()).toInt().toString())
            editText_fuelConsumption_DGU7_today.setText(((editText_coefficient_DGU7_today.text.toString().toDouble() / editText_densityFuel.text.toString().toDouble()) * textView_dayKWT_DGU7_today.text.toString().toInt()).toInt().toString())
            editText_fuelConsumption_DGU8_today.setText(((editText_coefficient_DGU8_today.text.toString().toDouble() / editText_densityFuel.text.toString().toDouble()) * textView_dayKWT_DGU8_today.text.toString().toInt()).toInt().toString())

            // After TO
            editText_afterServiceTO_today.setText(editText_afterServiceTO.text.toString().toInt().plus(textView_today_day_engineHours.text.toString().toInt()).toString())
            editText_afterServiceTO_DGU2_today.setText(editText_afterServiceTO_DGU2.text.toString().toInt().plus(textView_engineHours_DGU2_today.text.toString().toInt()).toString())
            editText_afterServiceTO_DGU3_today.setText(editText_afterServiceTO_DGU3.text.toString().toInt().plus(textView_engineHours_DGU3_today.text.toString().toInt()).toString())
            editText_afterServiceTO_DGU4_today.setText(editText_afterServiceTO_DGU4.text.toString().toInt().plus(textView_engineHours_DGU4_today.text.toString().toInt()).toString())
            editText_afterServiceTO_DGU5_today.setText(editText_afterServiceTO_DGU5.text.toString().toInt().plus(textView_engineHours_DGU5_today.text.toString().toInt()).toString())
            editText_afterServiceTO_DGU6_today.setText(editText_afterServiceTO_DGU6.text.toString().toInt().plus(textView_engineHours_DGU6_today.text.toString().toInt()).toString())
            editText_afterServiceTO_DGU7_today.setText(editText_afterServiceTO_DGU7.text.toString().toInt().plus(textView_engineHours_DGU7_today.text.toString().toInt()).toString())
            editText_afterServiceTO_DGU8_today.setText(editText_afterServiceTO_DGU8.text.toString().toInt().plus(textView_engineHours_DGU8_today.text.toString().toInt()).toString())

            // Remaining Oil
            edit_text_remainingOil_today.setText(((editText_remainingOil.text.toString().toInt() + editText_additionOil.text.toString().toInt() )- (
                    editText_oilConsumption_today.text.toString().toInt() +
                            editText_oilConsumption_DGU2_today.text.toString().toInt() +
                            editText_oilConsumption_DGU3_today.text.toString().toInt() +
                            editText_oilConsumption_DGU4_today.text.toString().toInt() +
                            editText_oilConsumption_DGU5_today.text.toString().toInt() +
                            editText_oilConsumption_DGU6_today.text.toString().toInt() +
                            editText_oilConsumption_DGU7_today.text.toString().toInt() +
                            editText_oilConsumption_DGU8_today.text.toString().toInt()
                    )).toString())

            // Day Consumption Fuel
            editText_allConsumptionFuel.setText((
                    textView_fuelConsumption_today.text.toString().toInt() +
                            editText_fuelConsumption_DGU2_today.text.toString().toInt() +
                            editText_fuelConsumption_DGU3_today.text.toString().toInt() +
                            editText_fuelConsumption_DGU4_today.text.toString().toInt() +
                            editText_fuelConsumption_DGU5_today.text.toString().toInt() +
                            editText_fuelConsumption_DGU6_today.text.toString().toInt() +
                            editText_fuelConsumption_DGU7_today.text.toString().toInt() +
                            editText_fuelConsumption_DGU8_today.text.toString().toInt()
                    ).toString())
            // Remaining Fuel
            editText_remainingFuel_today.setText(((editText_remainingFuel.text.toString().toInt() + edit_text_additionFuel.text.toString().toInt()) - editText_allConsumptionFuel.text.toString().toInt()).toString())
            // Weight Day Consumption Fuel
            edit_text_remainFuelWeight.setText((editText_allConsumptionFuel.text.toString().toInt() * editText_densityFuel.text.toString().toDouble()).toFloat().toString())

            //Fuel counter
            edit_text_fuelCounter_today.setText((editText_fuelCounter.text.toString().toInt() + editText_allConsumptionFuel.text.toString().toInt()).toString())

            // All day KWT of complex
            editText_allKWT_ofEnergyComplex.setText((textView_day_KWT_today.text.toString().toInt() +
                    textView_dayKWT_DGU2_today.text.toString().toInt() +
                    textView_dayKWT_DGU3_today.text.toString().toInt() +
                    textView_dayKWT_DGU4_today.text.toString().toInt() +
                    textView_dayKWT_DGU5_today.text.toString().toInt() +
                    textView_dayKWT_DGU6_today.text.toString().toInt() +
                    textView_dayKWT_DGU7_today.text.toString().toInt() +
                    textView_dayKWT_DGU8_today.text.toString().toInt()).toString())

            // All Engine Hours of Complex
            edit_text_allEngineRunHoursOfComplex.setText((textView_today_day_engineHours.text.toString().toInt() +
                    textView_engineHours_DGU2_today.text.toString().toInt() +
                    textView_engineHours_DGU3_today.text.toString().toInt() +
                    textView_engineHours_DGU4_today.text.toString().toInt() +
                    textView_engineHours_DGU5_today.text.toString().toInt() +
                    textView_engineHours_DGU6_today.text.toString().toInt() +
                    textView_engineHours_DGU7_today.text.toString().toInt() +
                    textView_engineHours_DGU8_today.text.toString().toInt()).toString())

            // Average coeff all complex
            editText_averageCoefficientAllComplex.setText((editText_allConsumptionFuel.text.toString().toDouble() / editText_allKWT_ofEnergyComplex.text.toString().toInt()).toFloat().toString())

            // The difference of remaining fuel
            edit_text_differenceRealRemainingAndOfficial.setText(((
                    edit_text_cistern1.text.toString().toInt() +
                            edit_text_cistern2.text.toString().toInt() +
                            edit_text_cistern3.text.toString().toInt() +
                            edit_text_cistern4.text.toString().toInt() +
                            edit_text_cistern5.text.toString().toInt() +
                            edit_text_cistern6.text.toString().toInt() +
                            edit_text_cistern7.text.toString().toInt() +
                            editText_allTanksOfDGU.text.toString().toInt()) - editText_remainingFuel_today.text.toString().toInt()).toString())

            editText_weightRemainingFuel.setText(editText_densityFuel.text.toString().toDouble().times(editText_remainingFuel_today.text.toString().toDouble()) .toFloat().toString())

            //kWT counter
            textView_KWT_today.text =      (     editText_activeEnergy_today.text.toString().toDouble() -      editText_activeEnergy.text.toString().toDouble()).times(editText_DGU_coefficient_transformation_field_today.text.toString().toInt()).toInt().toString()
            textView_KWT_DGU2_today.text = (editText_activeEnergy_DGU2_today.text.toString().toDouble() - editText_activeEnergy_DGU2.text.toString().toDouble()).times(editText_DGU_coefficient_transformation_field_today.text.toString().toInt()).toInt().toString()
            textView_KWT_DGU3_today.text = (editText_activeEnergy_DGU3_today.text.toString().toDouble() - editText_activeEnergy_DGU3.text.toString().toDouble()).times(editText_DGU_coefficient_transformation_field_today.text.toString().toInt()).toInt().toString()
            textView_KWT_DGU4_today.text = (editText_activeEnergy_DGU4_today.text.toString().toDouble() - editText_activeEnergy_DGU4.text.toString().toDouble()).times(editText_DGU_coefficient_transformation_field_today.text.toString().toInt()).toInt().toString()
            textView_KWT_DGU5_today.text = (editText_activeEnergy_DGU5_today.text.toString().toDouble() - editText_activeEnergy_DGU5.text.toString().toDouble()).times(editText_DGU_coefficient_transformation_field_today.text.toString().toInt()).toInt().toString()
            textView_KWT_DGU6_today.text = (editText_activeEnergy_DGU6_today.text.toString().toDouble() - editText_activeEnergy_DGU6.text.toString().toDouble()).times(editText_DGU_coefficient_transformation_field_today.text.toString().toInt()).toInt().toString()
            textView_KWT_DGU7_today.text = (editText_activeEnergy_DGU7_today.text.toString().toDouble() - editText_activeEnergy_DGU7.text.toString().toDouble()).times(editText_DGU_coefficient_transformation_field_today.text.toString().toInt()).toInt().toString()
            textView_KWT_DGU8_today.text = (editText_activeEnergy_DGU8_today.text.toString().toDouble() - editText_activeEnergy_DGU8.text.toString().toDouble()).times(editText_DGU_coefficient_transformation_field_today.text.toString().toInt()).toInt().toString()

            //difference first kwtCounter and second kwtCounter
            textView_differenceInKWT_today.text =      textView_day_KWT_today.text.toString().toInt().minus(textView_KWT_today.text.toString().toInt()).toString()
            textView_differenceInKWT_DGU2_today.text = textView_dayKWT_DGU2_today.text.toString().toInt().minus(textView_KWT_DGU2_today.text.toString().toInt()).toString()
            textView_differenceInKWT_DGU3_today.text = textView_dayKWT_DGU3_today.text.toString().toInt().minus(textView_KWT_DGU3_today.text.toString().toInt()).toString()
            textView_differenceInKWT_DGU4_today.text = textView_dayKWT_DGU4_today.text.toString().toInt().minus(textView_KWT_DGU4_today.text.toString().toInt()).toString()
            textView_differenceInKWT_DGU5_today.text = textView_dayKWT_DGU5_today.text.toString().toInt().minus(textView_KWT_DGU5_today.text.toString().toInt()).toString()
            textView_differenceInKWT_DGU6_today.text = textView_dayKWT_DGU6_today.text.toString().toInt().minus(textView_KWT_DGU6_today.text.toString().toInt()).toString()
            textView_differenceInKWT_DGU7_today.text = textView_dayKWT_DGU7_today.text.toString().toInt().minus(textView_KWT_DGU7_today.text.toString().toInt()).toString()
            textView_differenceInKWT_DGU8_today.text = textView_dayKWT_DGU8_today.text.toString().toInt().minus(textView_KWT_DGU8_today.text.toString().toInt()).toString()

            //drillers in kwt
            textView_activeEnDrillingTransformIn_KWT_today.text = (editText_activeEnDrilling_today.text.toString().toDouble() - editText_activeEnDrilling.text.toString().toDouble()).times(editText_driller_coefficient_transformation_field_today.text.toString().toInt()).toFloat().toString()

            //difference in k11wt energoComplex and drillers
            if(textView_activeEnDrillingTransformIn_KWT_today.text.toString() != "0.0")
                edit_text_active_difference_DGU_and_Driller_today.setText (editText_allKWT_ofEnergyComplex.text.toString().toInt().minus(textView_activeEnDrillingTransformIn_KWT_today.text.toString().toDouble()).toString())
        } catch (e: Exception){
            Toast.makeText(this, "Расчет не выполнен, неправильный формат данных - ${e.message}" , Toast.LENGTH_LONG).show()
        }
    }

    private fun formattingData(){
        val myNull = "0"
        for (i in arrayAdditionalToday){
            if(i.getText().trim().isEmpty() || i.text.toString() == ".")
                i.setText(myNull)
        }

        for (i in arrayAdditionalTomorrow){
            if(i.getText().trim().isEmpty() || i.text.toString() == ".")
                i.setText(myNull)
        }

        // Затирание нулями

        for (dgu in arrayToday){
//            dgu.prop02.setText(" ")
            if(dgu.prop01.getText().trim().isEmpty() || dgu.prop01.text.toString() == ".")  dgu.prop01.setText(myNull)
            if(dgu.prop02.getText().trim().isEmpty() || dgu.prop02.text.toString() == ".")  dgu.prop02.setText(myNull)
            if(dgu.prop03.getText().trim().isEmpty() || dgu.prop03.text.toString() == ".")  dgu.prop03.setText(myNull)
            if(dgu.prop04.getText().trim().isEmpty() || dgu.prop04.text.toString() == ".")  dgu.prop04.setText(myNull)
            if(dgu.prop05.getText().trim().isEmpty() || dgu.prop05.text.toString() == ".")  dgu.prop05.setText(myNull)
            if(dgu.prop06.getText().trim().isEmpty() || dgu.prop06.text.toString() == ".")  dgu.prop06.setText(myNull)
            if(dgu.prop07.getText().trim().isEmpty() || dgu.prop07.text.toString() == ".")  dgu.prop07.setText(myNull)
            if(dgu.prop08.getText().trim().isEmpty() || dgu.prop08.text.toString() == ".")  dgu.prop08.setText(myNull)
            if(dgu.prop09.getText().trim().isEmpty() || dgu.prop09.text.toString() == ".")  dgu.prop09.setText(myNull)
            if(dgu.prop10.getText().trim().isEmpty() || dgu.prop10.text.toString() == ".")  dgu.prop10.setText(myNull)
            if(dgu.prop11.getText().trim().isEmpty() || dgu.prop11.text.toString() == ".")  dgu.prop11.setText(myNull)
            if(dgu.prop12.getText().trim().isEmpty() || dgu.prop12.text.toString() == ".")  dgu.prop12.setText(myNull)
            if(dgu.prop13.getText().trim().isEmpty() || dgu.prop13.text.toString() == ".")  dgu.prop13.setText(myNull) }

        for (dgu in arrayTomorrow){
//            dgu.prop02.setText(" ")
            if(dgu.prop01.getText().trim().isEmpty())  dgu.prop01.setText(myNull)
            if(dgu.prop02.getText().trim().isEmpty())  dgu.prop02.setText(myNull)
            if(dgu.prop03.getText().trim().isEmpty())  dgu.prop03.setText(myNull)
            if(dgu.prop04.getText().trim().isEmpty())  dgu.prop04.setText(myNull)
            if(dgu.prop05.getText().trim().isEmpty())  dgu.prop05.setText(myNull)
            if(dgu.prop06.getText().trim().isEmpty())  dgu.prop06.setText(myNull)
            if(dgu.prop07.getText().trim().isEmpty())  dgu.prop07.setText(myNull)
            if(dgu.prop08.getText().trim().isEmpty())  dgu.prop08.setText(myNull)
            if(dgu.prop09.getText().trim().isEmpty())  dgu.prop09.setText(myNull)
            if(dgu.prop10.getText().trim().isEmpty())  dgu.prop10.setText(myNull)
            if(dgu.prop11.getText().trim().isEmpty())  dgu.prop11.setText(myNull)
            if(dgu.prop12.getText().trim().isEmpty())  dgu.prop12.setText(myNull)
            if(dgu.prop13.getText().trim().isEmpty())  dgu.prop13.setText(myNull) }

        Log.i("DEEN", arrayTomorrow.toString())

    }

    fun onClick(view: View) {
        calculation()
    }
    private var isSaved = false
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    } override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.action_save -> {
                if(saveData()){
                    Toast.makeText(this, "Сохраненно", Toast.LENGTH_SHORT).show()
                    isSaved = true; item.title = "Сохраненно в ${SimpleDateFormat("HH:mm dd-MMMM", Locale.getDefault()).format(Date())}"
                }
                return true}
            R.id.action_restore -> {restoreData(); return true}
//            R.id.action_rustik -> {motivationForRus(); return true}
            R.id.action_feedback -> {DialogFeedback().show(supportFragmentManager, "Dialog") ; return true}
        }
        return super.onOptionsItemSelected(item)
    } var back_pressed: Long = 0 ;

    override fun onBackPressed() {
        if (back_pressed + 1000 > System.currentTimeMillis()) {
            if(isSaved)
                super.onBackPressed()
            else Toast.makeText(this, "Cводка не сохранена!", Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(this, "Нажмите еще раз чтобы выйти.", Toast.LENGTH_SHORT).show()
            back_pressed = System.currentTimeMillis()
        }
    }
}