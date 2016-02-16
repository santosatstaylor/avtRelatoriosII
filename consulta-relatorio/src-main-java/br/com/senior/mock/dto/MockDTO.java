package br.com.senior.mock.dto;

public class MockDTO {
	
	/* MOCK´s */
	private static final String req001_produto            = "[{\"Produto\":\"Gestão de Pessoas\"}]";
	private static final String req002_sistema            = "[{\"Sistema\":\"FP\"}]";
	private static final String req003_extensao           = "[{\"Extensao\":[\"ANU\",\"CAD\",\"CAG\",\"CHE\",\"COL\",\"CPT\",\"CRE\",\"CTB\",\"ENV\",\"EPT\",\"EVT\",\"FGT\",\"GER\",\"GRC\",\"INT\",\"IRF\",\"LAN\",\"LIE\",\"OPE\",\"PRE\",\"PRV\",\"RCS\",\"SIN\"]}]";
	private static final String req004_categoria          = "[{\"Categoria\":[\"AF\",\"AP\",\"AR\",\"AV\",\"CA\",\"CB\",\"CC\",\"CH\",\"CO\",\"CP\",\"CT\",\"DA\",\"DE\",\"DF\",\"DI\",\"DO\",\"DR\",\"DT\",\"EC\",\"EG\",\"EM\",\"EN\",\"ES\",\"ET\",\"EX\",\"FE\",\"FF\",\"FR\",\"GE\",\"GR\",\"HI\",\"HO\",\"ID\",\"IM\",\"IN\",\"LA\",\"LF\",\"LI\",\"LO\",\"LV\",\"NR\",\"PC\",\"PE\",\"PF\",\"PG\",\"PO\",\"PR\",\"PU\",\"RC\",\"RD\",\"RE\",\"RF\",\"RL\",\"RN\",\"RS\",\"RT\",\"SA\",\"SM\",\"TA\",\"TE\",\"VA\",\"VT\"]}]";
	private static final String req005_relacao_relatorios = "[{\"Relação de Relatórios\":[\"FPAF002.COL\",\"FPAF003.COL\",\"FPAF004.COL\",\"FPAF005.COL\",\"FPAF006.COL\",\"FPAF007.COL\",\"FPAF008.COL\",\"FPAF009.COL\",\"FPAF010.COL\",\"FPAF011.COL\",\"FPAR048.CRE\",\"FPAR049.CRE\",\"FPAR050.CRE\",\"FPAR051.CRE\",\"FPAR052.CRE\",\"FPAR053.CRE\",\"FPAR055.CRE\",\"FPAR056.CRE\",\"FPAR057.CRE\",\"FPAR058.CRE\",\"FPAR059.CRE\",\"FPAR060.CRE\",\"FPAR061.CRE\",\"FPAR062.CRE\",\"FPAR063.CRE\",\"FPAV001.COL\",\"FPAV002.COL\",\"FPCB001.CTB\",\"FPCB002.CTB\",\"FPCO011.CAD\",\"FPCO012.CAD\",\"FPCP003.OPE\",\"FPDE007.COL\",\"FPDI002.ANU\",\"FPDI003.ANU\",\"FPDI004.ANU\",\"FPDI005.ANU\",\"FPDI006.ANU\",\"FPDO021.COL\",\"FPDO026.COL\",\"FPDO027.COL\",\"FPDO028.COL\",\"FPDO029.COL\",\"FPDO030.COL\",\"FPDO031.COL\",\"FPDO032.COL\",\"FPDO033.COL\",\"FPDO034.COL\",\"FPDR012.COL\",\"FPDR013.COL\",\"FPDR014.COL\",\"FPDR015.COL\",\"FPDR016.COL\",\"FPDR017.COL\",\"FPDR018.COL\",\"FPDR019.COL\",\"FPDR020.COL\",\"FPDR021.COL\",\"FPEG003.EPT\",\"FPEG004.EPT\",\"FPEG005.EPT\",\"FPEG006.EPT\",\"FPEM009.CAD\",\"FPEM010.CAD\",\"FPEM012.CAD\",\"FPEM013.CAD\",\"FPEM099.CAD\",\"FPEX002.ANU\",\"FPFF003.OPE\",\"FPFF004.OPE\",\"FPFF005.OPE\",\"FPFF006.OPE\",\"FPFF007.OPE\",\"FPFF008.OPE\",\"FPFR009.FGT\",\"FPFR010.FGT\",\"FPFR070.COL\",\"FPFR071.COL\",\"FPFR072.COL\",\"FPFR075.COL\",\"FPFR076.COL\",\"FPFR077.COL\",\"FPFR078.COL\",\"FPFR079.COL\",\"FPGE001.GER\",\"FPGE002.GER\",\"FPGE003.GER\",\"FPGE004.GER\",\"FPGE005.GER\",\"FPGE006.GER\",\"FPGE007.GER\",\"FPGE008.GER\",\"FPGR004.INT\",\"FPGR005.INT\",\"FPGR005.PRE\",\"FPGR006.INT\",\"FPGR007.GRC\",\"FPGR007.INT\",\"FPGR008.GRC\",\"FPGR009.GRC\",\"FPHI010.PRE\",\"FPHI011.PRE\",\"FPHI015.COL\",\"FPHI016.COL\",\"FPHI017.COL\",\"FPHI018.COL\",\"FPHI019.COL\",\"FPHI020.COL\",\"FPIN001.ANU\",\"FPIN002.ANU\",\"FPIN003.ANU\",\"FPIN004.ANU\",\"FPIN005.ANU\",\"FPIN006.ANU\",\"FPLA001.LAN\",\"FPLO004.CAD\",\"FPLO005.CAD\",\"FPNR001.PRV\",\"FPNR002.PRV\",\"FPNR003.PRV\",\"FPNR004.PRV\",\"FPNR005.PRV\",\"FPPG025.CRE\",\"FPPG028.CRE\",\"FPPG035.CRE\",\"FPPG041.CRE\",\"FPPG046.CRE\",\"FPPG047.CRE\",\"FPEG003.EPT\",\"FPEG004.EPT\",\"FPEG005.EPT\",\"FPEG006.EPT\",\"FPES005.OPE\",\"FPFF003.OPE\",\"FPFF004.OPE\",\"FPFF005.OPE\",\"FPFF006.OPE\",\"FPFF007.OPE\",\"FPFF008.OPE\",\"FPFR009.FGT\",\"FPFR010.FGT\",\"FPGR005.INT\",\"FPGR006.INT\",\"FPGR007.INT\",\"FPHI010.PRE\",\"FPHI011.PRE\",\"FPNR001.PRV\",\"FPNR002.PRV\",\"FPNR003.PRV\",\"FPNR004.PRV\",\"FPNR005.PRV\",\"FPPG025.CRE\",\"FPPG028.CRE\",\"FPPG035.CRE\",\"FPPG041.CRE\",\"FPPG046.CRE\",\"FPPG047.CRE\",\"FPPG051.CRE\",\"FPPG052.CRE\",\"FPPG053.CRE\",\"FPRD001.IRF\",\"FPRD002.IRF\",\"FPRE003.IRF\",\"FPRE004.IRF\",\"FPRE005.IRF\"]}]";
	private static final String req006_filtro_FPAF002     = "[{\"Relatório\":\"FPAF002.COL\",\"Filtro\":[\"01/11/2015\",\"23/11/2015\",\"Esse relatório precisa em média de 30 minutos para ser gerado !\"]}]";
	private static final String req006_filtro_FPAF003     = "[{\"Relatório\":\"FPAF003.COL\",\"Filtro\":[\"04/11/2015\",\"15/11/2015\",\"Esse relatório precisa em média de 20 minutos para ser gerado !\"]}]";
	private static final String req006_filtro_FPAF004     = "[{\"Relatório\":\"FPAF004.COL\",\"Filtro\":[\"10/11/2015\",\"10/11/2015\",\"Esse relatório precisa em média de 5 minutos para ser gerado !\"]}]";
	private static final String req006_filtro_FPAF005     = "[{\"Relatório\":\"FPAF005.COL\",\"Filtro\":[\"15/11/2015\",\"30/11/2015\",\"Esse relatório precisa em média de 25 minutos para ser gerado !\"]}]";
	private static final String req006_filtro_FPAF006     = "[{\"Relatório\":\"FPAF006.COl\",\"Filtro\":[\"18/11/2015\",\"20/11/2015\",\"Esse relatório precisa em média de 8 minutos para ser gerado !\"]}]";
	private static final String req006_filtro_FPPG041     = "[{\"Relatório\":\"FPPG041.CRE\",\"Filtro\":[\"10/11/2015\",\"12/11/2015\",\"Esse relatório precisa em média de 8 minutos para ser gerado !\"]}]";
	private static final String req006_filtro_FPEG003     = "[{\"Relatório\":\"FPEG003.EPT\",\"Filtro\":[\"13/11/2015\",\"15/11/2015\",\"Esse relatório precisa em média de 3 minutos para ser gerado !\"]}]";
	private static final String req006_filtro_FPFF007     = "[{\"Relatório\":\"FPFF007.OPE\",\"Filtro\":[\"11/11/2015\",\"12/11/2015\",\"Esse relatório precisa em média de 3 minutos para ser gerado !\"]}]";
	private static final String req006_filtro_FPFR010     = "[{\"Relatório\":\"FPFR010.FGT\",\"Filtro\":[\"07/11/2015\",\"07/11/2015\",\"Esse relatório precisa em média de 1 minuto para ser gerado !\"]}]";
	private static final String req006_filtro_FPRE005     = "[{\"Relatório\":\"FPRE005.IRF\",\"Filtro\":[\"01/11/2015\",\"30/11/2015\",\"Esse relatório precisa em média de 60 minutos para ser gerado !\"]}]";
	private static final String req006_filtro_inexistente = "[\"Relatório\":\"Inexistente\"]";
	private static final String req007_relatorios_prontos = "[{\"Relatório\":\"FPAF002.COL\",\"Geração\":[\"01/11/2015\",\"09:30\"]},{\"Relatório\":\"FPAF003.COL\",\"Geração\":[\"01/11/2015\",\"10:00\"]},{\"Relatório\":\"FPAF004.COL\",\"Geração\":[\"03/11/2015\",\"09:00\"]},{\"Relatório\":\"FPAF005.COL\",\"Geração\":[\"03/11/2015\",\"09:15\"]},{\"Relatório\":\"FPAF006.COL\",\"Geração\":[\"05/11/2015\",\"11:25\"]},{\"Relatório\":\"FPPG041.CRE\",\"Geração\":[\"05/11/2015\",\"11:35\"]},{\"Relatório\":\"FPEG003.EPT\",\"Geração\":[\"07/11/2015\",\"15:10\"]},{\"Relatório\":\"FPFF007.OPE\",\"Geração\":[\"07/11/2015\",\"15:15\"]},{\"Relatório\":\"FPFR010.FGT\",\"Geração\":[\"10/11/2015\",\"16:45\"]},{\"Relatório\":\"FPRE005.IRF\",\"Geração\":[\"10/11/2015\",\"16:55\"]}]";

	public static String getReq001_produto() { return req001_produto; }
	
	public static String getReq002_sistema() { return req002_sistema; }
	
	public static String getReq003_extensao() { return req003_extensao; }
	
	public static String getReq004_categoria() { return req004_categoria; }

	public static String getReq005_relacao_relatorios() { return req005_relacao_relatorios; }
	
	public static String getReq006_filtro_FPAF002() { return req006_filtro_FPAF002; }
	
	public static String getReq006_filtro_FPAF003() { return req006_filtro_FPAF003; }
	
	public static String getReq006_filtro_FPAF004() { return req006_filtro_FPAF004; }
	
	public static String getReq006_filtro_FPAF005() { return req006_filtro_FPAF005; }
	
	public static String getReq006_filtro_FPAF006() { return req006_filtro_FPAF006; }
	
	public static String getReq006_filtro_FPPG041() { return req006_filtro_FPPG041; }
	
	public static String getReq006_filtro_FPEG003() { return req006_filtro_FPEG003; }
	
	public static String getReq006_filtro_FPFF007() { return req006_filtro_FPFF007; }
	
	public static String getReq006_filtro_FPFR010() { return req006_filtro_FPFR010; }
	
	public static String getReq006_filtro_FPRE005() { return req006_filtro_FPRE005; }
	
	public static String getReq006_filtro_inexistente() { return req006_filtro_inexistente; }
	
	public static String getReq007_relatorios_prontos() { return req007_relatorios_prontos; }
	
}
