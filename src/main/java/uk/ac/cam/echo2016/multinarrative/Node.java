package uk.ac.cam.echo2016.multinarrative;

/**
 * 
 * @author tr393
 *
 */
import java.util.ArrayList;

public abstract class Node { //TODO Documentation
	private String id;
	protected android.os.BaseBundle properties;
	private ArrayList<Narrative> options = new ArrayList<Narrative>();

	public Node(String id) {
		this.id = id;
	}

	public abstract android.os.BaseBundle startNarrative(Narrative option);

	public abstract GameChoice onEntry(Narrative played, NarrativeInstance instance);

	public String getIdentifier() {
		return id;
	}

	public android.os.BaseBundle getProperties() {
		return properties;
	}

	public ArrayList<Narrative> getOptions() {
		return options;
	}
}