package cn.edu.hevttc.psy.strategies;

import java.util.*;
import java.sql.*;
public class Calculate {
		int[] score = new int[187];
		int[] arrayA = {3,26,27,51,52,76,101,126,151,176};
		int[] arrayB = {28,53,54,77,78,102,103,127,128,152,153,177,178,180};
		int[] arrayC = {4,5,29,30,55,79,80,104,105,129,130,154,179};
		int[] arrayE = {6,7,32,56,57,81,106,131,155,156,180,181};
		int[] arrayF = {8,33,58,82,83,107,108,132,133,157,158,182,183};
		int[] arrayG = {9,34,59,84,109,134,159,160,184,185};
		int[] arrayH = {10,35,36,60,61,85,86,110,111,135,136,161,186};
		int[] arrayI = {11,12,37,62,87,112,137,138,162,163};
		int[] arrayL = {13,38,63,64,88,89,113,114,139,164};
		int[] arrayM = {14,15,39,40,65,90,91,115,116,140,141,165,166};
		int[] arrayN = {16,17,41,42,66,67,92,117,142,167};
		int[] arrayO = {18,19,43,44,68,69,93,94,118,119,143,144,168};
		int[] arrayQ1 = {20,21,45,46,70,95,120,145,169,170};
		int[] arrayQ2 = {22,47,71,72,96,97,121,122,146,171};
		int[] arrayQ3 = {23,24,48,73,98,123,147,148,172,173};
		int[] arrayQ4 = {25,49,50,74,75,99,100,124,125,149,150,174,175};
		int elementA = 0;
		int elementB = 0;
		int elementC = 0;
		int elementE = 0;
		int elementF = 0;
		int elementG = 0;
		int elementH = 0;
		int elementI = 0;
		int elementL = 0;
		int elementM = 0;
		int elementN = 0;
		int elementO = 0;
		int elementQ1 = 0;
		int elementQ2= 0;
		int elementQ3= 0;
		int elementQ4= 0;
		public Calculate(int[] score){
			this.score = score;
		}
		public int calcul(int[] array,int[] score){
				int sum=0;
				for(int i=0;i<array.length;i++){
					sum = sum+score[array[i]];
				}
				return sum;
		}
		public String elementA(){
		String stringA = "";
		int priA = calcul(arrayA,score);
		switch (priA){
		case 0:
		case 1:
			elementA = 1;
			break;
		case 2:
		case 3:
			elementA = 2;
			break;
		case 4:
		case 5:
			elementA = 3;
	     	break;
		case 6:
		    elementA = 4;
		    break;
		case 7:
		case 8:
			elementA = 5;
			break;
		case 9:
		case 10:
		case 11:
			elementA = 6;
			break;
		case 12:
		case 13:
			elementA = 7;
			break;
		case 14:
			elementA = 8;
			break;
		case 15:
		case 16:
			elementA = 9;
			break;
		default:
			elementA = 10;
		}
		if(elementA<=3){
			stringA = "您的（乐群性）是低分特征：缄默，孤独，冷漠。";
		}
		else if(elementA>=8){
			stringA = "您的（乐群性）是高分特征：外向，热情，乐群。";
		}
		else{
		    stringA = "乐群性低分特征是缄默，孤独，冷漠；高分特征是外向，热情，乐群。您属于中间状态";
		}
		return stringA;
		}
		public String elementB(){
			String stringB = "";
			int priB = calcul(arrayB,score);
			switch (priB){
			case 0:
			case 1:
			case 2:
			case 3:
				elementB = 1;
				break;
			case 4:
				elementB = 2;
				break;
			case 5:
				elementB = 3;
		     	break;
			case 6:
			    elementB = 4;
			    break;
			case 7:
				elementB = 5;
				break;
			case 8:
				elementB = 6;
				break;
			case 9:
				elementB = 7;
				break;
			case 10:
				elementB = 8;
				break;
			case 11:
				elementB = 9;
				break;
	        default:
				elementB = 10;
			}
			if(elementB<=3){
				stringB = "您的（聪慧性）是低分特征：知识面比较窄，抽象思考能力比较弱。";
			}
			else if(elementB>=8){
				stringB = "您的（聪慧性）是高分特征：富有才识，善于抽象思考，学习能力强，思维敏捷。";
			}
			else{
			    stringB = "聪慧性的低分特征是知识面比较窄，抽象思考能力比较弱；高分特征是富有才识，善于抽象思考，学习能力强，思维敏捷。您属于中间状态";
			}
			return stringB;
		}
		public String elementC(){
			String stringC = "";
			int priC = calcul(arrayC,score);
			switch (priC){
			case 0:
			case 1:
			case 2:
			case 3:
			case 4:
			case 5:
				elementC = 1;
				break;
			case 6:
			case 7:
				elementC = 2;
				break;
			case 8:
			case 9:
				elementC = 3;
		     	break;
			case 10:
			case 11:
			    elementC = 4;
			    break;
			case 12:
			case 13:
				elementC = 5;
				break;
			case 14:
			case 15:
			case 16:
				elementC = 6;
				break;
			case 17:
			case 18:
				elementC = 7;
				break;
			case 19:
			case 20:
				elementC = 8;
				break;
			case 21:
			case 22:
				elementC = 9;
				break;
	        default:
				elementC = 10;
			}
			if(elementC<=3){
				stringC = "您的（稳定性）是低分特征：情绪激动，易生烦恼，心神动摇不定，易受环境支配。";
			}
			else if(elementC>=8){
				stringC = "您的（稳定性）是高分特征：情绪稳定而成熟，能面对现实。";
			}
			else{
			    stringC = "稳定性的低分特征是情绪激动，易生烦恼，心神动摇不定，易受环境支配；高分特征是情绪稳定而成熟，能面对现实。您属于中间状态";
			}
			return stringC;
		}
		public String elementE(){
			String stringE = "";
			int priE = calcul(arrayE,score);
			switch (priE){
			case 0:
			case 1:
			case 2:
				elementE = 1;
				break;
			case 3:
			case 4:
				elementE = 2;
				break;
			case 5:
				elementE = 3;
		     	break;
			case 6:
			case 7:
			    elementE = 4;
			    break;
			case 8:
			case 9:
				elementE = 5;
				break;
			case 10:
			case 11:
			case 12:
				elementE = 6;
				break;
			case 13:
			case 14:
				elementE = 7;
				break;
			case 15:
			case 16:
				elementE = 8;
				break;
			case 17:
			case 18:
				elementE = 9;
				break;
	        default:
				elementE = 10;
			}
			if(elementE<=3){
				stringE = "您的（恃强性）是低分特征：谦逊，顺从，通融，恭顺。";
			}
			else if(elementE>=8){
				stringE = "您的（恃强性）是高分特征：好强固执，独立积极。";
			}
			else{
			    stringE = "恃强性的低分特征是谦逊，顺从，通融，恭顺；高分特征是好强固执，独立积极。您属于中间状态";
			}
			return stringE;
		}
		public String elementF(){
			String stringF = "";
		int priF = calcul(arrayF,score);
		switch (priF){
		case 0:
		case 1:
		case 2:
		case 3:
			elementF = 1;
			break;
		case 4:
			elementF = 2;
			break;
		case 5:
		case 6:
			elementF = 3;
	     	break;
		case 7:
		    elementF = 4;
		    break;
		case 8:
		case 9:
			elementF = 5;
			break;
		case 10:
		case 11:
		case 12:
			elementF = 6;
			break;
		case 13:
		case 14:
			elementF = 7;
			break;
		case 15:
		case 16:
			elementF = 8;
			break;
		case 17:
		case 18:
			elementF = 9;
			break;
        default:
			elementF = 10;
		}
		if(elementF<=3){
			stringF = "您的（兴奋性）是低分特征：严肃，审慎，冷静，寡言。";
		}
		else if(elementF>=8){
			stringF = "您的（兴奋性）是高分特征：轻松兴奋，随遇而安。";
		}
		else{
		    stringF = "兴奋性的低分特征是严肃，审慎，冷静，寡言；高分特征是轻松兴奋，随遇而安。您是中间状态";
		}
		return stringF;
		}
		public String elementG(){
			String stringG = "";
			int priG = calcul(arrayG,score);
			switch (priG){
			case 0:
			case 1:
			case 2:
			case 3:
			case 4:
			case 5:
				elementG = 1;
				break;
			case 6:
			case 7:
				elementG = 2;
				break;
			case 8:
			case 9:
				elementG = 3;
		     	break;
			case 10:
			    elementG = 4;
			    break;
			case 11:
			case 12:
				elementG = 5;
				break;
			case 13:
			case 14:
				elementG = 6;
				break;
			case 15:
			case 16:
				elementG = 7;
				break;
			case 17:
				elementG = 8;
				break;
			case 18:
				elementG = 9;
				break;
	        default:
				elementG = 10;
			}
			if(elementG<=3){
				stringG = "您的（有恒性）是低分特征：苟且敷衍，缺乏奉公守法的精神。";
			}
			else if(elementG>=8){
				stringG = "您的（有恒性）是高分特征：有恒负责，做事尽责。";
			}
			else{
			    stringG = "有恒性的低分特征是苟且敷衍，缺乏奉公守法的精神；高分特征是有恒负责，做事尽责。您是中间状态";
			}
			return stringG;
		}
		public String elementH(){
			String stringH = "";
			int priH = calcul(arrayH,score);
			switch (priH){
			case 0:
			case 1:
				elementH = 1;
				break;
			case 2:
				elementH = 2;
				break;
			case 3:
				elementH = 3;
		     	break;
			case 4:
			case 5:
			case 6:
			    elementH = 4;
			    break;
			case 7:
			case 8:
				elementH = 5;
				break;
			case 9:
			case 10:
			case 11:
				elementH = 6;
				break;
			case 12:
			case 13:
			case 14:
				elementH = 7;
				break;
			case 15:
			case 16:
				elementH = 8;
				break;
			case 17:
			case 18:
			case 19:
				elementH = 9;
				break;
	        default:
				elementH = 10;
			}
			if(elementH<=3){
				stringH = "您的（敢为性）是低分特征：畏怯退缩缺乏自信心。";
			}
			else if(elementH>=8){
				stringH = "您的（敢为性）是高分特征：冒险敢为，少有顾忌。";
			}
			else{
			    stringH = "敢为性的低分特征是畏怯退缩缺乏自信心；高分特征是冒险敢为，少有顾忌。您是中间状态";
			}
			return stringH;
		}
		public String elementI(){
			String stringI = "";
		int priI = calcul(arrayI,score);
		switch (priI){
		case 0:
		case 1:
		case 2:
		case 3:
		case 4:
		case 5:
			elementI = 1;
			break;
		case 6:
			elementI = 2;
			break;
		case 7:
		case 8:
			elementI = 3;
	     	break;
		case 9:
		    elementI = 4;
		    break;
		case 10:
		case 11:
			elementI = 5;
			break;
		case 12:
		case 13:
			elementI = 6;
			break;
		case 14:
			elementI = 7;
			break;
		case 15:
		case 16:
			elementI = 8;
			break;
		case 17:
			elementI = 9;
			break;
        default:
			elementI = 10;
		}
		if(elementI<=3){
			stringI = "您的（敏感性）是低分特征：理智，着重现实，自食其力。";
		}
		else if(elementI>=8){
			stringI = "您的（敏感性）是高分特征：敏感，感情用事。";
		}
		else{
		    stringI = "敏感性的低分特征是苟理智，着重现实，自食其力；高分特征是敏感，感情用事。您是中间状态";
		}
		return stringI;
		}
		public String elementL(){
			String stringL = "";
		int priL = calcul(arrayL,score);
		switch (priL){
		case 0:
		case 1:
		case 2:
		case 3:
			elementL = 1;
			break;
		case 4:
		case 5:
			elementL = 2;
			break;
		case 6:
			elementL = 3;
	     	break;
		case 7:
		case 8:
		    elementL = 4;
		    break;
		case 9:
		case 10:
			elementL = 5;
			break;
		case 11:
		case 12:
			elementL = 6;
			break;
		case 13:
			elementL = 7;
			break;
		case 14:
		case 15:
			elementL = 8;
			break;
		case 16:
			elementL = 9;
			break;
        default:
			elementL = 10;
		}
		if(elementL<=3){
			stringL = "您的（怀疑性）是低分特征：理智，着重现实，自食其力。";
		}
		else if(elementL>=8){
			stringL = "您的（怀疑性）是高分特征：敏感，感情用事。";
		}
		else{
		    stringL = "怀疑性的低分特征是苟理智，着重现实，自食其力；高分特征是敏感，感情用事。您是中间状态";
		}
		return stringL;
		}
		public String elementM(){
			String stringM = "";
		int priM = calcul(arrayM,score);
		switch (priM){
		case 0:
		case 1:
		case 2:
		case 3:
		case 4:
		case 5:
			elementM = 1;
			break;
		case 6:
		case 7:
			elementM = 2;
			break;
		case 8:
		case 9:
			elementM = 3;
	     	break;
		case 10:
		case 11:
		    elementM = 4;
		    break;
		case 12:
		case 13:
			elementM = 5;
			break;
		case 14:
		case 15:
			elementM = 6;
			break;
		case 16:
		case 17:
			elementM = 7;
			break;
		case 18:
		case 19:
			elementM = 8;
			break;
		case 20:
			elementM = 9;
			break;
        default:
			elementM = 10;
		}
		if(elementM<=3){
			stringM = "您的（幻想性）是低分特征：现实，合乎成规，力求妥善合理。";
		}
		else if(elementM>=8){
			stringM = "您的（幻想性）是高分特征：幻想的，狂放不羁。";
		}
		else{
		    stringM = "幻想性的低分特征是现实，合乎成规，力求妥善合理；高分特征是幻想的，狂放不羁。您是中间状态";
		}
		return stringM;
		}
		public String elementN(){
			String stringN = "";
		int priN = calcul(arrayN,score);
		switch (priN){
		case 0:
		case 1:
		case 2:
			elementN = 1;
			break;
		case 3:
			elementN = 2;
			break;
		case 4:
			elementN = 3;
	     	break;
		case 5:
		case 6:
		    elementN = 4;
		    break;
		case 7:
		case 8:
			elementN = 5;
			break;
		case 9:
		case 10:
			elementN = 6;
			break;
		case 11:
			elementN = 7;
			break;
		case 12:
		case 13:
			elementN = 8;
			break;
		case 14:
			elementN = 9;
			break;
        default:
			elementN = 10;
		}
		if(elementN<=3){
			stringN = "您的（世故性）是低分特征：坦白，直率，天真。";
		}
		else if(elementN>=8){
			stringN = "您的（世故性）是高分特征：精明能干，世故。";
		}
		else{
		    stringN = "世故性的低分特征是坦白，直率，天真；高分特征是精明能干，世故。您是中间状态";
		}
		return stringN;
		}
		public String elementO(){
			String stringO="";
		int priO = calcul(arrayO,score);
		switch (priO){
		case 0:
		case 1:
		case 2:
			elementO = 1;
			break;
		case 3:
		case 4:
			elementO = 2;
			break;
		case 5:
		case 6:
			elementO = 3;
	     	break;
		case 7:
		case 8:
		    elementO = 4;
		    break;
		case 9:
		case 10:
			elementO = 5;
			break;
		case 11:
		case 12:
			elementO = 6;
			break;
		case 13:
		case 14:
			elementO = 7;
			break;
		case 15:
		case 16:
			elementO = 8;
			break;
		case 17:
		case 18:
			elementO = 9;
			break;
        default:
			elementO = 10;
		}
		if(elementO<=3){
			stringO = "您的（忧虑性）是低分特征：安详，沉着，有自信心。";
		}
		else if(elementO>=8){
			stringO = "您的（忧虑性）是高分特征：忧虑抑郁，烦恼自扰。";
		}
		else{
		    stringO = "忧虑性的低分特征是安详，沉着，有自信心；高分特征是忧虑抑郁，烦恼自扰。您是中间状态";
		}
		return stringO;
		}
		public String elementQ1(){
			String stringQ1="";
		int priQ1 = calcul(arrayQ1,score);
		switch (priQ1){
		case 0:
		case 1:
		case 2:
		case 3:
		case 4:
			elementQ1= 1;
			break;
		case 5:
			elementQ1= 2;
			break;
		case 6:
		case 7:
			elementQ1= 3;
	     	break;
		case 8:
		    elementQ1= 4;
		    break;
		case 9:
		case 10:
			elementQ1= 5;
			break;
		case 11:
		case 12:
			elementQ1= 6;
			break;
		case 13:
			elementQ1= 7;
			break;
		case 14:
			elementQ1= 8;
			break;
		case 15:
			elementQ1= 9;
			break;
        default:
			elementQ1= 10;
		}
		if(elementQ1<=3){
			stringQ1 = "您的（实验性）是低分特征：保守的，尊重传统观念与行为标准。";
		}
		else if(elementQ1>=8){
			stringQ1 = "您的（实验性）是高分特征：自由的，批评激进，不拘泥于现实。";
		}
		else{
		    stringQ1 = "实验性的低分特征是安详，沉着，有自信心；高分特征是忧虑抑郁，烦恼自扰。您是中间状态";
		}
		return stringQ1;
		}
		public String elementQ2(){
			String stringQ2="";
		int priQ2 = calcul(arrayQ2,score);
		switch (priQ2){
		case 0:
		case 1:
		case 2:
		case 3:
		case 4:
		case 5:
			elementQ2= 1;
			break;
		case 6:
		case 7:
			elementQ2= 2;
	     	break;
		case 8:
		    elementQ2= 3;
		    break;
		case 9:
		case 10:
			elementQ2= 4;
			break;
		case 11:
		case 12:
			elementQ2= 5;
			break;
		case 13:
		case 14:
			elementQ2= 6;
			break;
		case 15:
			elementQ2= 7;
			break;
		case 16:
		case 17:
			elementQ2= 8;
			break;
		case 18:
			elementQ2= 9;
			break;
        default:
			elementQ2= 10;
		}
		if(elementQ2<=3){
			stringQ2 = "您的（独立性）是低分特征：依赖，随群附众。";
		}
		else if(elementQ2>=8){
			stringQ2 = "您的（独立性）是高分特征：自立自强，当机立断。";
		}
		else{
		    stringQ2 = "独立性的低分特征是依赖，随群附众；高分特征是自立自强，当机立断。您是中间状态";
		}
		return stringQ2;
		}
		public String elementQ3(){
			String stringQ3="";
		int priQ3 = calcul(arrayQ3,score);
		switch (priQ3){
		case 0:
		case 1:
		case 2:
		case 3:
		case 4:
			elementQ3= 1;
			break;
		case 5:
		case 6:
			elementQ3= 2;
			break;
		case 7:
		case 8:
			elementQ3= 3;
	     	break;
		case 9:
		case 10:
		    elementQ3= 4;
		    break;
		case 11:
		case 12:
			elementQ3= 5;
			break;
		case 13:
		case 14:
			elementQ3= 6;
			break;
		case 15:
			elementQ3= 7;
			break;
		case 16:
		case 17:
			elementQ3= 8;
			break;
		case 18:
			elementQ3= 9;
			break;
        default:
			elementQ3= 10;
		}
		if(elementQ3<=3){
			stringQ3 = "您的（自律性）是低分特征：矛盾冲突，不顾大体。";
		}
		else if(elementQ3>=8){
			stringQ3 = "您的（自律性）是高分特征：知己知彼，自律严谨。";
		}
		else{
		    stringQ3 = "自律性的低分特征是矛盾冲突，不顾大体；高分特征是知己知彼，自律严谨。您是中间状态";
		}
		return stringQ3;
		}
		public String elementQ4(){
			String stringQ4="";
		int priQ4 = calcul(arrayQ4,score);
		switch (priQ4){
		case 0:
		case 1:
		case 2:
			elementQ4= 1;
			break;
		case 3:
		case 4:
			elementQ4= 2;
			break;
		case 5:
		case 6:
			elementQ4= 3;
	     	break;
		case 7:
		case 8:
		    elementQ4= 4;
		    break;
		case 9:
		case 10:
		case 11:
			elementQ4= 5;
			break;
		case 12:
		case 13:
		case 14:
			elementQ4= 6;
			break;
		case 15:
		case 16:
			elementQ4= 7;
			break;
		case 17:
		case 18:
		case 19:
			elementQ4= 8;
			break;
		case 20:
		case 21:
			elementQ4= 9;
			break;
        default:
			elementQ4= 10;
		}
		if(elementQ4<=3){
			stringQ4 = "您的（紧张性）是低分特征：心气平和，闲散宁静。";
		}
		else if(elementQ4>=8){
			stringQ4 = "您的（紧张性）是高分特征：紧张困扰，激动挣扎。";
		}
		else{
		    stringQ4 = "紧张性的低分特征是心气平和，闲散宁静；高分特征是紧张困扰，激动挣扎。您是中间状态";
		}
		return stringQ4;
		}
	public String X1(){
		int X1;
		String Xs1 = "";
		X1= ((38+2*elementL+3*elementO+4*elementQ4)-(2*elementC+2*elementH+2*elementQ2))/10;
		if(X1<=3){
			Xs1="适应于焦虑型：您是低分特征：生活适应顺利，通常感到心满意足，能做到所期望的及自认为重要的事情。如分数极低，则可能对困难的工作缺乏毅力，有事事知难而退，不肯奋斗努力的倾向。";
		}else if(X1>=8){
			Xs1="适应于焦虑型：您是高分特征：不一定有神经症，因为它可能是情境性的，但也可能有一些调节不良的情况，即对生活上所要求的和自己意欲达成的事情常感到不满意。高度的焦虑可能会使工作受到破坏和影响身体健康。";
		}
		else{
			Xs1="适应于焦虑型低分特征：生活适应顺利，通常感到心满意足，能做到所期望的及自认为重要的事情。如分数极低，则可能对困难的工作缺乏毅力，有事事知难而退，不肯奋斗努力的倾向。高分特征：不一定有神经症，因为它可能是情境性的，但也可能有一些调节不良的情况，即对生活上所要求的和自己意欲达成的事情常感到不满意。高度的焦虑可能会使工作受到破坏和影响身体健康。您是中间状态。";
		}
		return Xs1;
	}
	public String X2(){
		int X2;
		String Xs2 = "";
		X2= ((2*elementA+3*elementE+4*elementF+5*elementH)-(2*elementQ2+11))/10;
		if(X2<=3){
			Xs2="内向型与外向型：您是低分特征：内倾，趋于胆小，自足，在与别人接触中采取克制态度，有利于从事精细工作。这种类型无所谓利弊，主要取决于在哪种情况下采取这种态度。";
		}else if(X2>=8){
			Xs2="内向型与外向型：您是高分特征：外倾，开朗，善于交际，不受拘束，有利于从事贸易工作。";
		}else{
			Xs2="内向型与外向型低分特征：内倾，趋于胆小，自足，在与别人接触中采取克制态度，有利于从事精细工作。这种类型无所谓利弊，主要取决于在哪种情况下采取这种态度。高分特征：外倾，开朗，善于交际，不受拘束，有利于从事贸易工作。您是中间状态。";
		}
		return Xs2;
	}
	public String X3(){
		int X3;
		String Xs3 = "";
		X3= ((77+2*elementC+2*elementE+2*elementF+2*elementN)-(4*elementA+6*elementI+2*elementM))/10;
		if(X3<=3){
			Xs3="感情用事与安详机警型：您是低分特征：情感丰富而感到困扰不安，它可能是缺乏信心、颓丧的类型，对生活中的细节较为含蓄敏感，性格温和，讲究生活艺术，采取行动前再三思考，顾虑太多。";
		}else if(X3>=8){
			Xs3="感情用事与安详机警型：您是高分特征：富有事业心，果断，刚毅，有进取精神，精力充沛，行动迅速，但常忽视生活上的细节，只对明显的事物注意，有时会考虑不周，不计后果，冒然行事。";
		}else{
			Xs3="感情用事与安详机警型：情感丰富而感到困扰不安，它可能是缺乏信心、颓丧的类型，对生活中的细节较为含蓄敏感，性格温和，讲究生活艺术，采取行动前再三思考，顾虑太多。高分特征：富有事业心，果断，刚毅，有进取精神，精力充沛，行动迅速，但常忽视生活上的细节，只对明显的事物注意，有时会考虑不周，不计后果，冒然行事。您是中间状态。";
		}
		
		return Xs3;
	}
	public String X4(){
		int X4;
		String Xs4 = "";
		X4= ((4*elementE+3*elementM+4*elementQ1+4*elementQ2)-(3*elementA+2*elementG))/10;
		if(X4<=3){
			Xs4="怯懦与果断型：您是低分特征：赖别人，纯洁，个性被动，受人驱使而不能独立，对支持他的人在行动上常适应其需求，为获取别人的欢心会事事迁就。";
		}else if(X4>=8){
			Xs4="怯懦与果断型：您是高分特征：果断，独立，露锋芒，有气魄，有攻击性的倾向，通常会主动地寻找可以施展这种行为的环境或机会，以充分表现自己的独创能力，并从中取得利益。";
		}else{
			Xs4="怯懦与果断型低分特征：赖别人，纯洁，个性被动，受人驱使而不能独立，对支持他的人在行动上常适应其需求，为获取别人的欢心会事事迁就。高分特征：果断，独立，露锋芒，有气魄，有攻击性的倾向，通常会主动地寻找可以施展这种行为的环境或机会，以充分表现自己的独创能力，并从中取得利益。您是中间状态。";
		}
		return Xs4;
	}
	public String Y1(){
		int y1 = elementC+elementF+(11-elementO)+(11-elementQ4);
		return "您的心理健康因素为"+y1+"分，心理健康状况几乎是一切职业及事业成功的基础。心理不健康者，其学习和工作效率都会因之减低。心理健康标准可介于4-40之间，均值为22分。低于12分者仅占人数分配的10%，情绪不稳定的程度颇为显著。";
	}
	public String Y2(){
		int y2 = elementQ3*2+elementG*2+elementC*2+elementE+elementN+elementQ2+elementQ1;
		return "您的专业有成就者的人格因素为"+y2+"分，本次级因素意指人格中的某些因素可能对将来的专业成就所具有的影响，它并不代表将来专业成就所达到的水平。其总分可介于10-100之间，平均分为55，67以上者其成功的机会更大。";
	}
	public String Y3(){
		int y3=(11-elementA)*2+elementB*2+elementE+(11-elementF)*2+elementH+elementI*2+elementM+(11-elementN)+elementQ1+elementQ2*2;
		return "您的创造力强者的人格因素为"+y3+"分，高于70者属于创造力强者的范围，应有其成就。";
	}
	public String Y4(){
		int y4 = elementB+elementG+elementQ3+(11-elementF);
		return "您的在新环境中有成长能力的人格因素为"+y4+"分，本次级因素总分可介于4-40之间，平均值为22分，不足17分者仅占人数的10%左右，从事专业或训练成功的可能性较小。25分以上者，则有成功的希望。";
	}
}
