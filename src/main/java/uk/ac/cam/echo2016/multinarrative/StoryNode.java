package uk.ac.cam.echo2016.multinarrative;

import java.io.Serializable;
import java.util.ArrayList;

import android.os.BaseBundle;

/**
 * Represents a {@code Node} on the {@code MultiNarrative} graph structure. Each node has an {@code ArrayList} of
 * {@code Narrative} references leaving the {@code Node}.
 * 
 * @author tr393
 * @author rjm232
 * @version 1.0
 *
 */
public abstract class StoryNode implements Serializable, Cloneable { // TODO Documentation
    private static final long serialVersionUID = 1;
    private final String id;
    private BaseBundle properties;
    private ArrayList<Route> entryRoutes;
    private ArrayList<Route> exitRoutes;

    public StoryNode(String id) {
        this.id = id;
        this.exitRoutes = new ArrayList<Route>();
        this.entryRoutes = new ArrayList<Route>();
        // TODO: (Please check) I added this bc getProperties was returning null
        // please fix if this is not createProperties' intended use
        // this.createProperties();
    }

    @Override
    public StoryNode clone() {
        try {
            StoryNode clone = (StoryNode) super.clone();
            clone.properties = BaseBundle.deepcopy(this.properties);

            return clone;
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Method is implemented in derived classes ChoiceNode and SyncNode, to allow this class to make new objects of
     * those derived types in the copyToGraph method.
     * 
     * @param id
     * @return
     */
    protected abstract StoryNode create(String id);

    public abstract BaseBundle startRoute(Route option);

    public abstract GameChoice onEntry(Route played, NarrativeInstance instance) throws GraphElementNotFoundException;

    public String getId() {
        return id;
    }

    public void createProperties() {
        if (properties == null)
            properties = new BaseBundle(4);
    }

    public BaseBundle getProperties() {
        return properties;
    }

    public void setProperties(BaseBundle b) {
        properties = b;
    }

    public ArrayList<Route> getEntering() {
        return entryRoutes;
    }

    public void setEntering(ArrayList<Route> entryRoutes) {
        this.entryRoutes = entryRoutes;
    }

    public ArrayList<Route> getExiting() {
        return exitRoutes;
    }

    public void setExiting(ArrayList<Route> exitRoutes) {
        this.exitRoutes = exitRoutes;
    }

}