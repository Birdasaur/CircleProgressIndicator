package birdasaur.CircleProgressIndicator;

import javafx.scene.paint.Color;

/**
 *
 * @author birdasaur
 */
public class ProgressStatus {

    public Color fillStartColor = Color.CYAN;
    public Color fillEndColor = Color.CYAN;
    public Color innerStrokeColor = Color.CYAN;
    public Color outerStrokeColor = Color.CYAN;
    public String statusMessage = "";
    public double percentComplete; //-1 for indeterminate

    public ProgressStatus(String statusMessage, double percentComplete) {
        this.statusMessage = statusMessage;
        this.percentComplete = percentComplete;
    }
    
}
