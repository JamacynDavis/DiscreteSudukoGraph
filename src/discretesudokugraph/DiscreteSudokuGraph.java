package discretesudokugraph;

/** Sudoku Graph Project 
* Jamacyn Davis 
* September 20, 2021 

* Description: This program displays a nine by nine Sudoku board and correctly 
* colors it. An example correct board is used and is stored in the sudokuArr. The 
* nine colors are then assigned to numbers in the Sudoku array. All of adjacent edges 
* are added, so that adjacent vertices will be assigned different colors. 
* 
package discretesudokugraph;
*/

public class DiscreteSudokuGraph {

    public static void main(String[] args) {
        int invalidx = -1;  
        int invalidy = -1;
        //sudukoArr = new int[9][9]; 
        int[][] sudokuArr = 
                {{1, 2, 3,   8, 6, 7,   4, 5, 9},
                {4, 5, 9,   1, 2, 3,   8, 6, 7}, 
                {8, 6, 7,   4, 5, 9,   1, 2, 3}, 
                {2, 9, 1,   3, 4, 8,   5, 7, 6},
                {3, 7, 8,   5, 9, 6,   2, 4, 1},
                {5, 4, 6,   2, 7, 1,   3, 9, 8}, 
                {9, 1, 4,   6, 8, 2,   7, 3, 5},
                {7, 8, 2,   9, 3, 5,   6, 1, 4}, 
                {6, 3, 5,   7, 1, 4,   9, 8, 2}};   
                
        String[] colors = {"Yellow", "Blue", "Orange", "Purple", "Red", "Aqua", "Green", "Light Blue", "Light Green"};
        
        String[][] colorsArr = new String[sudokuArr.length][sudokuArr[0].length]; 
        for (int i = 0; i < sudokuArr.length; i += 1) { 
            for ( int j = 0; j < sudokuArr.length; j += 1 ) { 
                if ( sudokuArr[i][j] == 1 ){ 
                    colorsArr[i][j] = colors[0]; 
                }
                if ( sudokuArr[i][j] == 2 ){ 
                    colorsArr[i][j] = colors[1]; 
                }
                if ( sudokuArr[i][j] == 3 ){ 
                    colorsArr[i][j] = colors[2]; 
                }
                if ( sudokuArr[i][j] == 4 ){ 
                    colorsArr[i][j] = colors[3]; 
                }
                if ( sudokuArr[i][j] == 5 ){ 
                    colorsArr[i][j] = colors[4]; 
                }                
                if ( sudokuArr[i][j] == 6 ){ 
                    colorsArr[i][j] = colors[5]; 
                }                
                if ( sudokuArr[i][j] == 7 ){ 
                    colorsArr[i][j] = colors[6]; 
                }                
                if ( sudokuArr[i][j] == 8 ){ 
                    colorsArr[i][j] = colors[7]; 
                } 
                if ( sudokuArr[i][j] == 9 ){ 
                    colorsArr[i][j] = colors[8]; 
                }
            }
            
        }
        int[][] edges = new int[2000][4];
        
        // edgeCount keeps track of the edges added
        int edgeCount = 0; 
        
        // This adds all the edges between the adjacent vertices across the rows 
        for(int i = 0; i < sudokuArr.length; i+=1){     // row of first and second index held constant 
            for(int j = 0; j < sudokuArr[i].length; j+=1){     // column of first vertex 
                for(int k = 0; k < sudokuArr[i].length; k+=1){   // column of the second that keeps moving until all are done for that j value 
                    if ( j == k ) { 
                        // do nothing 
                    }
                    else { 
                        edges[edgeCount][0] = j;
                        edges[edgeCount][1] = i;
                        edges[edgeCount][2] = k;
                        edges[edgeCount][3] = i; 
                        edgeCount++; 
                    } 
                }
            }
        }
         
        // This adds all the edges between the adjacent vertices down the columns
        for(int j = 0; j < sudokuArr.length; j+=1){     // column is held constant 
            for(int i = 0; i < sudokuArr[j].length; i+=1) { // row of first vertex
                for(int k = 0; k < sudokuArr[j].length; k+=1){  // second row value in point that keeps moving until all edges are built for that row
                    if ( i == k ) { 
                        // do nothing 
                    }
                    else { 
                        edges[edgeCount][0] = j; // same column
                        edges[edgeCount][1] = i; // inner for loop so first point value 
                        edges[edgeCount][2] = j; // same column 
                        edges[edgeCount][3] = k; // outer for loop so second poitn value 
                        edgeCount++; 
                    }
                }
            
            }
        }
    
    // This adds all the edges adjacent to the vertices in the three by three subboxes in the graph 
        for ( int box = 0; box < 9; box += 1) { // Represents the 8 3 by 3 boxes in graph 
            for( int i = (box%3)*3; i < (box%3)*3 + 3; i += 1 ) { // columns across the graph and writes them in terms of box. 
                for ( int j = box/3*3; j < box/3*3 + 3; j +=1 ) { // rows down the graph using box to make sure it is within the 3 by 3 box.
                    for ( int k = (box%3)*3; k < (box%3)*3 + 3; k += 1) { // second x vertex for second point of adjacency
                        for ( int f = box/3*3; f < box/3*3; f += 1) { // second y vertex for second point of adjacency. 
                            if ( i == k || j == f ) { // already down in the above for loops for adjacienecies across the columns and down the rows. 
                            // do nothing 
                            }
                            else { 
                                edges[edgeCount][0] = i; // x coordinate 
                                edges[edgeCount][1] = j; // y coordinate  
                                edges[edgeCount][2] = k; // second x coordinate 
                                edges[edgeCount][3] = f; // second y coordinate 
                                edgeCount++; // keeps track of the edges 
                            }
                        }
                    }    
                }
            }
        }
        
        // checks if adjacent vertices are colored the same, then it outputs invalid
        for ( int x = 0; x < edgeCount; x += 1){ 
            if (colors[sudokuArr[edges[x][0]][edges[x][1]] - 1] == colors[sudokuArr[edges[x][2]][edges[x][3]] - 1]){ 
                System.out.println("Invalid");    
                invalidx = edges[x][0]; 
                invalidy = edges[x][1]; 
                break; 
            }
        } 
    
    // creates the board display 
    Board b = new Board(colorsArr, colorsArr.length, invalidx, invalidy); 
    // Board b = new Board(colorsArr, colorsArr.length, 0, 0); 
    }
   
    
}
        
        
        
        // if ( sudokuArr[edges[x][0]][edges[x][1]] == sudokuArr[edges[x][2]][edges[x][3]])  
       
    