
public class GraphsArea extends Widget{
	
	// Define
	public int CHARACTER_GRAPH = 0;
	public int EPISODE_GRAPH = 1;
	public int SEASON_GRAPH = 2;

	// Graph area contains at most 3 charts
	BarChart chart1;
	BarChart chart2;
	BarChart chart3;
	
	TagCloud tagCloud1;
	TagCloud tagCloud2;
	TagCloud tagCloud3;
	
	TableChart tableChart1;
	TableChart tableChart2;
	TableChart tableChart3;
	
	// Number of charts we want to display at the moment
	public int chartsNumber = 0;
	
	// Horizontal scrollbar for selecting starting and ending episodes
	public HorizontalScrollBar scroll;
	
	// Rollover rectangle and label to be displayed 
	public Widget rolloverRect;
	public String rolloverLabel;
	
	public GraphsArea() {
	
	}
	
	public void draw() {
		
		if (chart1 != null)
			chart1.draw();
		if (chart2 != null)
			chart2.draw();
		if (chart3 != null)
			chart3.draw();
		
		if (tagCloud1 != null)
			tagCloud1.draw();
		if (tagCloud2 != null)
			tagCloud2.draw();
		if (tagCloud3 != null)
			tagCloud3.draw();
		
		if (tableChart1 != null)
			tableChart1.draw();
		if (tableChart2 != null)
			tableChart2.draw();
		if (tableChart3 != null)
			tableChart3.draw();
		
		if (GLOBAL.ANALYSIS_TYPE.equals("characters")) {
			scroll.draw();
			
			if (rolloverRect != null && ( chart1 != null && chart1.mouseOver()) || ( chart2 != null && chart2.mouseOver()) || (chart3 != null && chart3.mouseOver()) ) {
				rolloverRect.draw();
				GLOBAL.processing.fill(GLOBAL.colorText);
				GLOBAL.processing.textFont(GLOBAL.tFont,18);
				GLOBAL.processing.textAlign(GLOBAL.processing.CENTER);
				GLOBAL.processing.text(rolloverLabel, x + width/2 - 50, y + height - 70);
			}
		}

	}

	// Create a new graph for character analysis
	public void createCharacterGraph() {
		// IF plot graphs
		if (GLOBAL.STAT_VIEW == false) {
			if (GLOBAL.WORD_ANALYSIS == false) {
				if (chart1 == null) {
					chart1 = new BarChart(GLOBAL.CHARACTER_SELECTED, x + 20, y + 20, width - 20, height - 120, CHARACTER_GRAPH);
				}
				else if (chart2 == null) {
					int chartHeight = (height - 140)/2;
					chart2 = chart1;
					chart2.changePosition(x + 20, y + 40 + chartHeight, width - 20, chartHeight);
					chart1 = new BarChart(GLOBAL.CHARACTER_SELECTED, x + 20, y + 20, width - 20, chartHeight, CHARACTER_GRAPH);
				}
				else {
					int chartHeight = (height - 160)/3;
					chart3 = chart2;
					chart2 = chart1;
					// chart 2 and 3 = change x y width height
					chart2.changePosition(x + 20, y + 40 + chartHeight, width - 20, chartHeight);
					chart3.changePosition(x + 20, y + 60 + 2*chartHeight, width - 20, chartHeight);
					chart1 = new BarChart(GLOBAL.CHARACTER_SELECTED, x + 20, y + 20, width - 20, chartHeight, CHARACTER_GRAPH);	
				}
			}
			else {
				if (tagCloud1 == null) {
					tagCloud1 = new TagCloud(GLOBAL.CHARACTER_SELECTED, x + 20, y + 20, width - 20, height - 120);
				}
				else if (tagCloud2 == null) {
					int chartHeight = (height - 140)/2;
					tagCloud2 = tagCloud1;
					tagCloud2.changePosition(x + 20, y + 40 + chartHeight, width - 20, chartHeight);
					tagCloud1 = new TagCloud(GLOBAL.CHARACTER_SELECTED, x + 20, y + 20, width - 20, chartHeight);
				}
				else {
					int chartHeight = (height - 160)/3;
					tagCloud3 = tagCloud2;
					tagCloud2 = tagCloud1;
					// chart 2 and 3 = change x y width height
					tagCloud2.changePosition(x + 20, y + 40 + chartHeight, width - 20, chartHeight);
					tagCloud3.changePosition(x + 20, y + 60 + 2*chartHeight, width - 20, chartHeight);
					tagCloud1 = new TagCloud(GLOBAL.CHARACTER_SELECTED, x + 20, y + 20, width - 20, chartHeight);	
				}
			}
		}
		// ELSE plot table view
		else {
			if (GLOBAL.WORD_ANALYSIS == false) {
				if (tableChart1 == null) {
					tableChart1 = new TableChart(GLOBAL.CHARACTER_SELECTED, x + 20, y + 20, width - 20, height - 120, CHARACTER_GRAPH);
				}
				else if (tableChart2 == null) {
					int chartHeight = (height - 140)/2;
					tableChart2 = tableChart1;
					tableChart2.changePosition(x + 20, y + 40 + chartHeight, width - 20, chartHeight);
					tableChart1 = new TableChart(GLOBAL.CHARACTER_SELECTED, x + 20, y + 20, width - 20, chartHeight, CHARACTER_GRAPH);
				}
				else {
					int chartHeight = (height - 160)/3;
					tableChart3 = tableChart2;
					tableChart2 = tableChart1;
					// chart 2 and 3 = change x y width height
					tableChart2.changePosition(x + 20, y + 40 + chartHeight, width - 20, chartHeight);
					tableChart3.changePosition(x + 20, y + 60 + 2*chartHeight, width - 20, chartHeight);
					tableChart1 = new TableChart(GLOBAL.CHARACTER_SELECTED, x + 20, y + 20, width - 20, chartHeight, CHARACTER_GRAPH);	
				}
			}
		}

	}
	
	// Create a new graph for episode analysis	
	public void createEpisodeGraph() {
		if (chart1 == null)
			chart1 = new BarChart(GLOBAL.EPISODE_SELECTED, x + 20, y + 20, width - 100, height - 20, EPISODE_GRAPH);
		else if (chart2 == null) {
			chart2 = chart1;
			chart2.changePosition(x + 20, y + (height)/2 + 30, width - 100, (height - 100) /2);
			chart1 = new BarChart(GLOBAL.EPISODE_SELECTED, x + 20, y + 20, width - 100, (height - 100) /2, EPISODE_GRAPH);
			}
		else {
			int chartHeight = (height - 160)/3;
			chart3 = chart2;
			chart2 = chart1;
			// chart 2 and 3 = change x y width height
			chart2.changePosition(x + 20, y + 80 + chartHeight, width - 100, chartHeight);
			chart3.changePosition(x + 20, y + 140 + 2*chartHeight, width - 100, chartHeight);
			chart1 = new BarChart(GLOBAL.EPISODE_SELECTED, x + 20, y + 20, width - 100, chartHeight, EPISODE_GRAPH);		}
		
	}
	
	// Create a new graph for season analysis	
	public void createSeasonGraph() {
		
		if (chart1 == null)
			chart1 = new BarChart(GLOBAL.SEASON_SELECTED, x + 20, y + 20, width - 100, height - 20, SEASON_GRAPH);
		else if (chart2 == null) {
			chart2 = chart1;
			chart2.changePosition(x + 20, y + (height)/2 + 30, width - 100, (height - 100) /2);
			chart1 = new BarChart(GLOBAL.SEASON_SELECTED, x + 20, y + 20, width - 100, (height - 100) /2, SEASON_GRAPH);
			}
		else {
			int chartHeight = (height - 160)/3;
			chart3 = chart2;
			chart2 = chart1;
			// chart 2 and 3 = change x y width height
			chart2.changePosition(x + 20, y + 80 + chartHeight, width - 100, chartHeight);
			chart3.changePosition(x + 20, y + 140 + 2*chartHeight, width - 100, chartHeight);
			chart1 = new BarChart(GLOBAL.SEASON_SELECTED, x + 20, y + 20, width - 100, chartHeight, SEASON_GRAPH);		}
		
	}
	
	public void clearGraphs() {
		chart1 = null;
		chart2 = null;
		chart3 = null;
		tagCloud1 = null;
		tagCloud2 = null;
		tagCloud3 = null;
		tableChart1 = null;
		tableChart2 = null;
		tableChart3 = null;
	}
	
	public void doAction() {

		if (scroll.mouseOver())
			scroll.mousePressed();
		
		if (GLOBAL.STAT_VIEW) {
			if (tableChart1 != null && tableChart1.mouseOver())
				tableChart1.doAction();
			if (tableChart2 != null && tableChart2.mouseOver())
				tableChart2.doAction();
			if (tableChart3 != null && tableChart3.mouseOver())
				tableChart3.doAction();
		}
	}

	public void createScrollBar() {
		
		scroll = new HorizontalScrollBar(Parser.LIST_ALL);
		scroll.x = this.x + 20;
		scroll.y = this.y + this.height - 50;
		scroll.width = this.width - 120;
		scroll.height = 15;	
		scroll.size = (float)2/ Parser.LIST_ALL.size();
		
	}
	
	public void mouseRolloverFunction( float RectWidth, float x, String s ) {
		
		rolloverRect = new Widget();
		rolloverRect.x = (int)(x - RectWidth/2);
		rolloverRect.y = (int)(y + 20);
		rolloverRect.width = (int)(RectWidth);
		rolloverRect.height = (int)(height - 120);
		
		rolloverLabel = s;
		
	}

	public void mouseReleased() {
		scroll.mouseReleased();
		if (GLOBAL.STAT_VIEW) {
			if (tableChart1 != null)
				tableChart1.scroll.mouseReleased();
			if (tableChart2 != null)
				tableChart2.scroll.mouseReleased();
			if (tableChart3 != null)
				tableChart3.scroll.mouseReleased();
		}	}

}
