package ecstech;

import java.util.concurrent.Executors;

import javax.swing.JFrame;
import com.mxgraph.swing.mxGraphComponent;
import com.mxgraph.view.mxGraph;




public class WorkFlow extends JFrame {
	
	private static final long serialVersionUID = -2707712944901661771L;

	public WorkFlow()
	{
		super("Ingest Pipeline");

		mxGraph graph = new mxGraph();
		Object parent = graph.getDefaultParent();

		graph.getModel().beginUpdate();
		try
		{
			Object createTiles = graph.insertVertex(parent, null, "Create Tiles", 20, 20, 80,
					30);
			Object smartTag = graph.insertVertex(parent, null, "Smart Tag", 240, 150,
					80, 30);
			Object uploadSwift = graph.insertVertex(parent, null, "Upload Swift", 640, 150,
					80, 30);
			graph.insertEdge(parent, null, "Edge", createTiles, smartTag);
			graph.insertEdge(parent, null, "Edge", smartTag, uploadSwift);
		}
		finally
		{
			graph.getModel().endUpdate();
		}

		mxGraphComponent graphComponent = new mxGraphComponent(graph);
		getContentPane().add(graphComponent);
	}
	
	public void runScript(String p_command) {
		Process process;
		try {
			process = Runtime.getRuntime().exec(p_command);
			System.out.println(process.getOutputStream().toString());
			
		} catch (Exception ex) {
			
		}

	}
	
	
	
	
	public static void main(String[] args) {
		WorkFlow frame = new WorkFlow();
//		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		frame.setSize(800, 640);
//		frame.setVisible(true);
		
		frame.runScript("bash /home/huy.nguyen/test.sh");
	}

}
