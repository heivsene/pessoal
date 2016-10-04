package amazon.exam;

import java.io.IOException;



public class Solution {

       /*Robot class*/
       private static class Robot {
             int north = 0;
             int south = 0;
             int east = 0;
             int west = 0;
             
             /*get the cartesian x,y*/
             public String getDirection(){
                    int x = 0;
                    int y = 0;
                    x += this.east;
                    y += this.north;
                    x -= this.west;
                    y -= this.south;           
                    return "("+x+","+y+")";
             }
       }
       
       
       
       static String moveRobot(String s) {
             char[] commands = new  char[s.length()];
             Robot robot = new Robot();
             
             /*checking which commands reached here*/
             for (int i = 0; i < commands.length; i++) {
                    commands[i] = s.charAt(i);
                    switch (commands[i]) {
                    case 'N':
                           robot.north = 1;
                           break;
                    case 'S':
                           robot.south = 1;
                           break;
                    case 'E':
                           robot.east = 1;
                           break;
                    case 'W':
                           robot.west = 1;
                           break;
                    }

                    if(!Character.isDigit(commands[i])){
                           /*checking if commands are right*/
                           if(commands[i] != 'N' && commands[i] != 'S' && commands[i] != 'E' && 
                                        commands[i] != 'W' && commands[i] != 'X'){
                                  System.out.println("("+999+","+999+")");
                                  return "("+999+","+999+")";
                           }
                    }
             }

             for (int i = 0; i < commands.length; i++) {
                    /*checking how many steps the robot would move*/
                    if(Character.isDigit(commands[i])){
                           switch (commands[i+1]) {
                           case 'N':
                                  robot.north = Integer.parseInt(Character.toString(commands[i]));
                                  break;
                           case 'S':
                                  robot.south = Integer.parseInt(Character.toString(commands[i]));
                                  break;
                           case 'E':
                                  robot.east = Integer.parseInt(Character.toString(commands[i]));
                                  break;
                           case 'W':
                                  robot.west = Integer.parseInt(Character.toString(commands[i]));
                                  break;
                           }                          
                    } else {
                           /*checking whether cancel any commands*/
                           if (commands[i] == 'X'){
                                  /*for reverse to verify canceling commands*/
                                  for (int j = i-1; j >= 0; --j) {
                                        boolean changed = false;
                                        switch (commands[j]) {
                                        case 'N':
                                               if(robot.north > 0){                                                             
                                                      robot.north = 0;
                                                      changed = true;
                                               }
                                               break;
                                        case 'S':
                                               if(robot.south > 0){                                                             
                                                      robot.south = 0;
                                                      changed = true;
                                               }
                                               break;
                                        case 'E':
                                               if(robot.east > 0){                                                       
                                                      robot.east = 0;
                                                      changed = true;
                                               }
                                               break;
                                        case 'W':
                                               if(robot.west > 0){                                                       
                                                      robot.west = 0;
                                                      changed = true;
                                               }
                                               break;
                                        }

                                        if(changed)
                                               break;
                                  }
                           }
                    }
             }

             System.out.println(robot.getDirection());
             return robot.getDirection();
       }
}
