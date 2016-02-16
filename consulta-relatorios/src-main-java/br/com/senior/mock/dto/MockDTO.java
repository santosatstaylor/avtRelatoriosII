package br.com.senior.mock.dto;

public class MockDTO {
	
	/* MOCK´s */
	private static final String req001_produto            = "[{\"Produto\":\"Gestão de Pessoas\"}]";
	private static final String req002_sistema            = "[{\"Sistema\":\"FP\"}]";
	private static final String req003_extensao           = "[{\"Extensao\":[\"ANU\",\"CAD\",\"CAG\",\"CHE\",\"COL\",\"CPT\",\"CRE\",\"CTB\",\"ENV\",\"EPT\",\"EVT\",\"FGT\",\"GER\",\"GRC\",\"INT\",\"IRF\",\"LAN\",\"LIE\",\"OPE\",\"PRE\",\"PRV\",\"RCS\",\"SIN\"]}]";
	private static final String req004_categoria          = "[{\"Categoria\":[\"AF\",\"PG\",\"EG\",\"FF\",\"FR\",\"RE\"]}]";
	private static final String req005_relacao_relatorios = "[{\"Relação de Relatórios\":[\"FPAF002.COL\",\"FPAF003.COL\",\"FPAF004.COL\",\"FPAF005.COL\",\"FPAF006.COL\",\"FPPG041.CRE\",\"FPEG003.EPT\",\"FPFF007.OPE\",\"FPFR010.FGT\",\"FPRE005.IRF\"]}]";
	private static final String req006_filtro_FPAF002     = "[{\"Nome\":\"avt_arquivo - 28-01-2015 15:04:36\",\"Relatorio\":\"avt_arquivo.pdf\",\"Caminho\":\"http://192.168.99.164:8080/consulta-relatorios/api/gera-binario?arquivo=//PCIND00427/arquivos/\"},{\"Nome\":\"FPTA023 - 29-01-2015 06:45:54\",\"Relatorio\":\"FPTA023.PDF\",\"Caminho\":\"http://192.168.99.164:8080/consulta-relatorios/api/gera-binario?arquivo=//PCIND00427/arquivos/\"}]";
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
