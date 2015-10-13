<?php


    
?>

<html>
    <head >
        
    <div style="height:200px">
        <center> <img src="\sabin\picture\bannerUTA.jpg" alt= " Image not found" style="height:200px;width:940px;margin:0;padding:0"><center>
            
    </div>
</head><br>
    <style>
        #Menu
        {
            height :425px;
            width: 940px;
           
           background-color: #006666;
            margin:auto;
           
        }
        #container1
        {
           height :425px;
           width: 760px;
           background-color: #006666;
           float:left;
           // margin:10px;  
        }
        #container2
        {
           height :425px;
           width: 175px;
           background-color: #006666;
           float:right;
           // margin:10px;  
        }
        #box1
        {
           height:60px;
           width:200px;
         //  background-color:#000000;
           float: left;
         
           
        }
        #box2
        {
           height:60px;
           width:200px;
         //  background-color:#006666;
           float:left;
           
        }
        #box1{
            
           height:375px;
           width:350px;
           background-color:#666666;
           border-style: solid;
           border-width:2px;
          margin-left:20px;
          color:white;
          float:left;
           overflow:scroll;
           
            }
        #box2{
            
          height:375px;
           width:350px;
           background-color:#666666;
           border-style: solid;
           border-width:2px;
          margin-right:20px;
          color:white;
          float:right;
           overflow:scroll;
           
            }
 
          
        #box3
        {
           height:50px;
            width:150px;
            background-color:#006666;
            margin:auto;
            //float:left;
        
        } 
              
        #box4
        {
           height:50px;
           width:150px;
           background-color:#006666;
           margin:auto;
            //float:left;
        
        } 

 
        #box5
        {
           height:50px;
           width:150px;
           background-color:#006666;
           margin:auto;
        }
    
         #box3:hover
        {
            background-color:#0000FF;
        }
         #box4:hover
        {
            background-color:#0000FF;
        }
         #box5:hover
        {
            background-color:#0000FF;
        }
        
    </style>
    <body style="background-color:#cccccc">
 
        <div id="Menu">
            <div id="container1"><br>
                 <div id="box1">
                     <label style = "font-size:25px; color:yellow;margin-left:20px"> Ratings for Professor </label><br><br>
                   <?php 
                 session_start();
               
                require('connect.php');
                $Id = '';
                $Name='';
                $LastName = '';
                $department = '';
                
                 
                $myData =mysql_query (  "SELECT * FROM Professor");
                while($record = mysql_fetch_array($myData))
                {
                    $counter = 0;
                    $array[] = null;
                    $Ratings= '';
                    $Comment = '';
                    $avgrating = 0;
                    $i = 0;
                    $count2 = 0;
                
                    $myData2 =mysql_query (  "SELECT * FROM Ratings");
                    $Id = $record['ID'];
                    $Name = $record['Name'];
                    $LastName = $record['LastName'];
                    while($record2 = mysql_fetch_array($myData2))
                    {
                        if($Id == $record2['Id'])
                        {
                             $department = $record2['Dept'];
                             $Ratings = $record2['AvgRating'];
                             $avgrating = $avgrating + $Ratings;
                             $counter ++;
                        }                              
                       
                    }
                    
                   $myData3 =mysql_query (  "SELECT * FROM Comment");
                    while($record3 = mysql_fetch_array($myData3))
                    {
                       if($Id == $record3['ID'])
                       {

                            if($record3['Comment'] !='')
                            {
                               $Comment =  $record3['Comment']; 
                               $array[$count2] = $Comment;
                               $count2++;
                            }
                       }
                    }
                    
                    if($counter> 0)
                    {
                            echo "<label style='margin-left:20px'>Id: ".$Id. "</label><br>" ;
                            echo "<label style='margin-left:20px'> Name : ".$Name . " ".$LastName . "</label><br>";
                            echo "<label style='margin-left:20px'>Department : ".$department. "</label><br>";
                            echo "<label style='margin-left:20px'>Ratings: ". $avgrating/$counter. "</label><br>";
                           
                  
                            $myData3 =mysql_query (  "SELECT * FROM Comment");
                            while($record3 = mysql_fetch_array($myData3))
                            {
                               if($Id == $record3['ID'])
                               {
                                    $Comment =  $record3['Comment'];
                                    if($Comment != '')
                                    {
                                         echo "<label style='margin-left:20px'>Comment : ".$Comment."</label><br>";
                                    }
                               }
                            }
                            
                             echo"<hr>";
                    }
                }
                                   
                                  
                                
                ?>
                
            </div>
                <div id="box2">
                    <label style = "font-size:25px; color:yellow;margin-left:20px">Ratings for College Services</label><br><br>
                <?php 
                
               
                require('connect.php');
                $Id = '';
                $Name='';
                $LastName = '';
                
                
                 
                $myData =mysql_query (  "SELECT * FROM Services");
                while($record = mysql_fetch_array($myData))
                {
                    $counter = 0;
                    $array[] = null;
                    $Ratings= '';
                    $Comment = '';
                    $avgrating = 0;
                    $i = 0;
                    $count2 = 0;
                
                    $myData2 =mysql_query (  "SELECT * FROM ServiceRating");
                    $Id = $record['Id'];
                    $Name = $record['Name'];
                    $Service = $record['Service'];
                    while($record2 = mysql_fetch_array($myData2))
                    {
                        if($Id == $record2['Id'])
                        {
                             
                             $Ratings = $record2['Rating'];
                             $avgrating = $avgrating + $Ratings;
                             $counter ++;
                        }                              
                       
                    }
                    
                   $myData3 =mysql_query (  "SELECT * FROM ServiceComment");
                    while($record3 = mysql_fetch_array($myData3))
                    {
                       if($Id == $record3['Id'])
                       {

                            if($record3['ServiceComment'] != '')
                            {
                               $Comment =  $record3['ServiceComment']; 
                               $array[$count2] = $Comment;
                               $count2++;
                            }
                       }
                    }
                    
                    if($counter> 0)
                    {
                            echo " <label style='margin-left:20px'>Id: ".$Id. "</label><br>" ;
                            echo "<label style='margin-left:20px'> Name : ".$Name . " ".$LastName . "</label><br>";
                            
                            echo "<label style='margin-left:20px'>Ratings: ". $avgrating/$counter. "</label><br>";
                    
                            $myData3 =mysql_query (  "SELECT * FROM ServiceComment");
                            while($record3 = mysql_fetch_array($myData3))
                            {
                               if($Id == $record3['Id'])
                               {
                                    $Comment =  $record3['ServiceComment'];
                                    if($Comment != '')
                                    {
                                       echo "<label style='margin-left:20px'>Comment : ".$Comment."</label><br>";
                                         
                                    }
                               }
                            }
                            echo"<hr>";
                    }
                  
                }
                                   
                                  
                                
                ?>
            </div>
            </div>
            <div id="container2"><br><br>
                <div id="box3"><a href="Professor.php"><img  src="\sabin\picture\RateProfessor.png" alt= " Image not found" style=" height:50px; width:150px"></a>
                </div><br>
                <div id="box4">
                     <a href="Service.php"><img  src="\sabin\picture\RATEService.png" alt= " Image not found" style=" height:50px; width:150px"></a>
                </div><br>
                  <div id="box5">
                
            
             <?php
                          
                            $User= $_SESSION['user'];
                            $Pass=$_SESSION['pass'];
                     if(($User=='Admin')&&($Pass=='Admin123'))
                     {
                         $site="AdminPage.php";
                     }
                     else
                     {
                         $site="UserPage.php";
                     }
                     ?>
                      <center><a href=<?php echo $site;?>><img  src="\sabin\picture\HOME BUTTON.jpg" alt= " Image not found" style="margin-top:4px;height:40px; width:140px"></a></center>
                   
                </div>
            </div>
      
          
      
            
        </div>
  
    </body>          
                   
         
</html>