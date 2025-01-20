# Table Cell Renderer with Text Highlighting

Now, modify your jTextField9KeyReleased method to use this renderer:

```java
private void jTextField9KeyReleased(java.awt.event.KeyEvent evt) {                                        
    String searchText = jTextField9.getText();
    
    // Apply the custom renderer to all columns
    for (int i = 0; i < jTable1.getColumnCount(); i++) {
        jTable1.getColumnModel().getColumn(i).setCellRenderer(
            new HighlightTableCellRenderer(searchText)
        );
    }
    
    // Repaint the table to show the highlighting
    jTable1.repaint();
    
    // Optional: Filter the table rows
    DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
    TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<>(model);
    jTable1.setRowSorter(sorter);
    
    if (searchText.length() == 0) {
        sorter.setRowFilter(null);
    } else {
        sorter.setRowFilter(RowFilter.regexFilter("(?i)" + searchText));
    }
}
```

Also, add these imports at the top of your file:

```java
import javax.swing.RowFilter;
import javax.swing.table.TableRowSorter;
```

This implementation:

Creates a custom TableCellRenderer that highlights cells containing the search text
Applies a light yellow highlight to matching text
Preserves the table's selection highlighting
Updates the highlighting in real-time as the user types
Optionally filters the table rows to show only matching results
Is case-insensitive for better user experience

The highlighting will be visible across all columns, making it easy for users to spot matching text anywhere in the table. The light yellow background helps draw attention to matches while maintaining readability.

If you want to apply the highlighting only to column 1 (First Name column) in the table, here's how to modify the code:
```java
private void jTextField9KeyReleased(java.awt.event.KeyEvent evt) {                                        
    String searchText = jTextField9.getText();
    
    // Apply the custom renderer only to column 1 (First Name)
    jTable1.getColumnModel().getColumn(1).setCellRenderer(
        new HighlightTableCellRenderer(searchText)
    );
    
    // Repaint the table to show the highlighting
    jTable1.repaint();
    
    // Optional: Filter the table rows
    DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
    TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<>(model);
    jTable1.setRowSorter(sorter);
    
    if (searchText.length() == 0) {
        sorter.setRowFilter(null);
    } else {
        sorter.setRowFilter(RowFilter.regexFilter("(?i)" + searchText, 1)); // The second parameter '1' specifies to only search column 1
    }
}
```
    
}
The key changes are:

Removed the loop and applied the renderer only to column 1
Added column index (1) to the RowFilter to only search in the First Name column

This will now only highlight and search matches in the First Name column while leaving other columns unchanged.
