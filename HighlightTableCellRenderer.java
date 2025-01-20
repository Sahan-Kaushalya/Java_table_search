import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.JTable;
import javax.swing.JLabel;
import java.awt.Component;
import java.awt.Color;

public class HighlightTableCellRenderer extends DefaultTableCellRenderer {
    private String searchText;
    
    public HighlightTableCellRenderer(String searchText) {
        this.searchText = searchText.toLowerCase();
    }
    
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value,
            boolean isSelected, boolean hasFocus, int row, int column) {
        
        Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
        
        if (value != null && searchText != null && !searchText.isEmpty()) {
            String text = value.toString().toLowerCase();
            if (text.contains(searchText)) {
                if (!isSelected) {
                    c.setBackground(new Color(255, 255, 0, 100)); // Light yellow highlight
                } else {
                    c.setBackground(table.getSelectionBackground());
                }
            } else {
                if (!isSelected) {
                    c.setBackground(table.getBackground());
                } else {
                    c.setBackground(table.getSelectionBackground());
                }
            }
        } else {
            if (!isSelected) {
                c.setBackground(table.getBackground());
            } else {
                c.setBackground(table.getSelectionBackground());
            }
        }
        
        return c;
    }
}
