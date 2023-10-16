package com.example.ruben_proyecto

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.ruben_proyecto.menus.*
import com.example.ruben_proyecto.menus.menu_x_xx.MenuProyecto_11_20
import com.example.ruben_proyecto.menus.menu_x_xx.MenuProyecto_1_10
import com.example.ruben_proyecto.menus.menu_x_xx.MenuProyecto_21_30
import com.example.ruben_proyecto.menus.menu_x_xx.MenuProyecto_31_40
import com.example.ruben_proyecto.menus.menu_x_xx.MenuProyecto_41_50
import com.example.ruben_proyecto.menus.menu_x_xx.MenuProyecto_51_60
import com.example.ruben_proyecto.menus.menu_x_xx.MenuProyecto_61_70
import com.example.ruben_proyecto.menus.menu_x_xx.MenuProyecto_71_80
import com.example.ruben_proyecto.menus.menu_x_xx.MenuProyecto_81_90
import com.example.ruben_proyecto.menus.menu_x_xx.MenuProyecto_91_100
import com.example.ruben_proyecto.project_11_20.*
import com.example.ruben_proyecto.project_1_10.*
import com.example.ruben_proyecto.project_21_30.*
import com.example.ruben_proyecto.project_31_40.*
import com.example.ruben_proyecto.project_41_50.*
import com.example.ruben_proyecto.project_51_60.*
import com.example.ruben_proyecto.project_61_70.*
import com.example.ruben_proyecto.project_71_80.*
import com.example.ruben_proyecto.project_81_90.*
import com.example.ruben_proyecto.project_91_100.*


import com.example.ruben_proyecto.ui.theme.Ruben_ProyectoTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Ruben_ProyectoTheme {
                Surface(
                    modifier = Modifier.fillMaxSize()
                ) {
                    val navController = rememberNavController()
                    NavHost(navController = navController, startDestination = "Menu") {
                        composable("Menu") { MenuProyecto(navController) }
                        composable("Menu_1_10") { MenuProyecto_1_10(navController) }
                        composable("Menu_11_20") { MenuProyecto_11_20(navController) }
                        composable("Menu_21_30") { MenuProyecto_21_30(navController) }
                        composable("Menu_31_40") { MenuProyecto_31_40(navController) }
                        composable("Menu_41_50") { MenuProyecto_41_50(navController) }
                        composable("Menu_51_60") { MenuProyecto_51_60(navController) }
                        composable("Menu_61_70") { MenuProyecto_61_70(navController) }
                        composable("Menu_71_80") { MenuProyecto_71_80(navController) }
                        composable("Menu_81_90") { MenuProyecto_81_90(navController) }
                        composable("Menu_91_100") { MenuProyecto_91_100(navController) }
                        composable("Project_5") { Project_5(navController) }
                        composable("Project_6") { Project_6(navController) }
                        composable("Project_7") { Project_7(navController) }
                        composable("Project_8") { Project_8(navController) }
                        composable("Project_9") { Project_9(navController) }
                        composable("Project_10") { Project_10(navController) }
                        composable("Project_11") { Project_11(navController) }
                        composable("Project_12") { Project_12(navController) }
                        composable("Project_13") { Project_13(navController) }
                        composable("Project_14") { Project_14(navController) }
                        composable("Project_15") { Project_15(navController) }
                        composable("Project_16") { Project_16(navController) }
                        composable("Project_17") { Project_17(navController) }
                        composable("Project_18") { Project_18(navController) }
                        composable("Project_19") { Project_19(navController) }
                        composable("Project_20") { Project_20(navController) }
                        composable("Project_21") { Project_21(navController) }
                        composable("Project_22") { Project_22(navController) }
                        composable("Project_23") { Project_23(navController) }
                        composable("Project_24") { Project_24(navController) }
                        composable("Project_25") { Project_25(navController) }
                        composable("Project_26") { Project_26(navController) }
                        composable("Project_27") { Project_27(navController) }
                        composable("Project_28") { Project_28(navController) }
                        composable("Project_29") { Project_29(navController) }
                        composable("Project_30") { Project_30(navController) }
                        composable("Project_31") { Project_31(navController) }
                        composable("Project_32") { Project_32(navController) }
                        composable("Project_33") { Project_33(navController) }
                        composable("Project_34") { Project_34(navController) }
                        composable("Project_35") { Project_35(navController) }
                        composable("Project_36") { Project_36(navController) }
                        composable("Project_37") { Project_37(navController) }
                        composable("Project_38") { Project_38(navController) }
                        composable("Project_39") { Project_39(navController) }
                        composable("Project_40") { Project_40(navController) }
                        composable("Project_41") { Project_41(navController) }
                        composable("Project_42") { Project_42(navController) }
                        composable("Project_43") { Project_43(navController) }
                        composable("Project_44") { Project_44(navController) }
                        composable("Project_45") { Project_45(navController) }
                        composable("Project_46") { Project_46(navController) }
                        composable("Project_47") { Project_47(navController) }
                        composable("Project_48") { Project_48(navController) }
                        composable("Project_49") { Project_49(navController) }
                        composable("Project_50") { Project_50(navController) }
                        composable("Project_51") { Project_51(navController) }
                        composable("Project_52") { Project_52(navController) }
                        composable("Project_53") { Project_53(navController) }
                        composable("Project_54") { Project_54(navController) }
                        composable("Project_55") { Project_55(navController) }
                        composable("Project_56") { Project_56(navController) }
                        composable("Project_57") { Project_57(navController) }
                        composable("Project_58") { Project_58(navController) }
                        composable("Project_59") { Project_59(navController) }
                        composable("Project_60") { Project_60(navController) }
                        composable("Project_61") { Project_61(navController) }
                        composable("Project_62") { Project_62(navController) }
                        composable("Project_63") { Project_63(navController) }
                        composable("Project_64") { Project_64(navController) }
                        composable("Project_65") { Project_65(navController) }
                        composable("Project_66") { Project_66(navController) }
                        composable("Project_67") { Project_67(navController) }
                        composable("Project_68") { Project_68(navController) }
                        composable("Project_69") { Project_69(navController) }
                        composable("Project_70") { Project_70(navController) }
                        composable("Project_71") { Project_71(navController) }
                        composable("Project_72") { Project_72(navController) }
                        composable("Project_73") { Project_73(navController) }
                        composable("Project_74") { Project_74(navController) }
                        composable("Project_75") { Project_75(navController) }
                        composable("Project_76") { Project_76(navController) }
                        composable("Project_77") { Project_77(navController) }
                        composable("Project_78") { Project_78(navController) }
                        composable("Project_79") { Project_79(navController) }
                        composable("Project_80") { Project_80(navController) }
                        composable("Project_81") { Project_81(navController) }
                        composable("Project_82") { Project_82(navController) }
                        composable("Project_83") { Project_83(navController) }
                        composable("Project_84") { Project_84(navController) }
                        composable("Project_85") { Project_85(navController) }
                        composable("Project_86") { Project_86(navController) }
                        composable("Project_87") { Project_87(navController) }
                        composable("Project_88") { Project_88(navController) }
                        composable("Project_89") { Project_89(navController) }
                        composable("Project_90") { Project_90(navController) }
                        composable("Project_91") { Project_91(navController) }
                        composable("Project_92") { Project_92(navController) }
                        composable("Project_93") { Project_93(navController) }
                        composable("Project_94") { Project_94(navController) }
                        composable("Project_95") { Project_95(navController) }
                        composable("Project_96") { Project_96(navController) }
                        composable("Project_97") { Project_97(navController) }
                        composable("Project_98") { Project_98(navController) }
                        composable("Project_99") { Project_99(navController) }
                        composable("Project_100") { Project_100(navController) }
                    }
                }
            }
        }
    }
}

