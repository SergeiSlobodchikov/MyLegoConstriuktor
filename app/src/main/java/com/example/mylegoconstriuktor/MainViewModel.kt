package com.example.mylegoconstriuktor

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.firstOrNull
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class MainViewModel(private val legoPartsDaoView: LegoPartsDao): ViewModel() {


    val allLegoParts = this.legoPartsDaoView.getAll()
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5000L),
            initialValue = emptyList()
        )

    val legoPartsList = listOf(
        "antenna_small_base_with_lever",
        "arch_1_x_6_raised_arch",
        "bracket_1_x_2___2_x_2",
        "brick__modified_1_x_1_with_open_o_clip_vertical_grip___hollow_stud",
        "brick__modified_1_x_1_with_scroll_with_hollow_stud",
        "brick__modified_1_x_14_with_groove",
        "brick__modified_1_x_2_with_grille_fluted_profile",
        "brick__modified_1_x_2_with_masonry_profile",
        "brick__modified_facet_2_x_2",
        "brick__round_1_x_1_open_stud",
        "brick__round_2_x_2_dome_bottom",
        "brick_1_x_1",
        "brick_1_x_1_x_3",
        "brick_1_x_12",
        "brick_1_x_16",
        "brick_1_x_2",
        "brick_1_x_2_x_2_with_inside_stud_holder",
        "brick_1_x_3",
        "brick_1_x_4",
        "brick_1_x_6",
        "brick_2_x_2_corner",
        "door__frame_1_x_6_x_7_arched_with_notches_and_rounded_pillars",
        "door_1_x_5_x_3_with_3_studs_and_handle",
        "pane_for_window_1_x_2_x_2_lattice_diamond",
        "panel_1_x_2_x_1_with_rounded_corners_and_2_sides",
        "panel_1_x_4_x_5_wall_with_window",
        "plate__modified_1_x_1_with_light_attachment___thick_ring",
        "plate__modified_1_x_1_with_open_o_clip_thick_vertical_grip",
        "plate__modified_1_x_2_with_bar_arm_up_horizontal_arm_5mm",
        "plate__modified_1_x_2_with_bar_handle_on_end",
        "plate__modified_1_x_4_offset",
        "plate__modified_1_x_4_with_2_studs_with_groove",
        "plate__round_1_x_1",
        "plate_1_x_1",
        "plate_1_x_2",
        "plate_1_x_4",
        "plate_2_x_2",
        "plate_2_x_3",
        "plate_2_x_4",
        "plate_2_x_6",
        "plate_4_x_6",
        "slope__inverted_45_2_x_1",
        "slope__inverted_45_2_x_2_with_flat_bottom_pin",
        "slope_30_1_x_1_x_0_66",
        "slope_45_1_x_1_x_0_66_quadruple_convex_pyramid",
        "slope_45_2_x_1_double_with_bottom",
        "support_1_x_1_x_6_solid_pillar",
        "technic__brick_1_x_1_with_hole",
        "technic__brick_1_x_2_with_holes",
        "technic__pin_without_friction_ridges",
        "tile__modified_1_x_1_with_open_o_clip",
        "tile__modified_2_x_2_triangular",
        "tile__modified_facet_2_x_2",
        "tile__round_2_x_2_with_open_stud",
        "tile_1_x_1_with_groove",
        "tile_1_x_2_with_groove",
        "tile_1_x_3",
        "tile_1_x_4",
        "tile_1_x_6",
        "tile_2_x_6",
        "wedge__plate_2_x_4",
        "window_1_x_2_x_2_flat_front"
    )

    fun onAddBtn() {
        viewModelScope.launch {
            for (i in 1..62) {
                // Проверяем, существует ли запись с таким идентификатором
                if (legoPartsDaoView.getLegoPartById(i) == null) {
                    val name = legoPartsList.getOrElse(i - 1) { "" } // Получаем имя из списка, используя индекс i-1
                    legoPartsDaoView.insert(
                        LegoParts(
                            id = i,
                            name = name,
                            quantity = 0
                        )
                    )
                }
            }
        }
    }

    fun onUpdateBtn(){
        viewModelScope.launch {
            allLegoParts.value.lastOrNull()?.let {
                val legoParts = it.copy(
                    name = "деталь 4 на 4"
                )
                legoPartsDaoView.update(legoParts)
            }
        }
    }

    fun onDeleteBtn(){
        viewModelScope.launch {
            allLegoParts.value.lastOrNull()?.let {legoPartsDaoView.delete(it)
            }
        }
    }

    fun showAllTable() {
        viewModelScope.launch {
            val allLegoParts = legoPartsDaoView.getAll().firstOrNull()
            val result = allLegoParts?.joinToString(separator = "\n") { "ID: ${it.id}, Name: ${it.name}, Quantity: ${it.quantity}" }
                ?: "No Lego parts found."
            Log.d("AllLegoParts", result)
        }
    }

}


