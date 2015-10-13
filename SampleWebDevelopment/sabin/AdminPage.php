<?php
require"connect.php";
  session_start();
  $user= $_SESSION['user'];
  $pass=$_SESSION['pass'];
  $Hello='';
  $First='';
  $Last='';
  $result = mysql_query("SELECT * FROM Registration");

        while($row = mysql_fetch_array($result))
        {
            if(($user==$row['UserName'])&&($pass==$row['Password']))
            {
                $First=$row['Name'];
                $Last=$row['LastName'];
                $Hello=$First." ".$Last;
            }
        }
?>





<html>
    <head >
        
        <center> <img src="\sabin\picture\header.jpg" alt= " Image not found" style="height:125px;width:900px"></center>
</head>
    <style>
        #Menu
        {
            height : 475px;
            width: 900px;
          //  background-color: #000000;
 }
        #hello
        {
            height:45px;
            width:900px;
            background-color:#006666;
        }
       
        #box1
        {
           height:200px;
           width:900px;
          // background-color:#00;
          
         
           
        }
        #box2
        {
           height:200px;
           width:900px;
          // background-color:#000000; 
      
        }
        #box00
        {
            height:200px;
            width:225px;
           // background-color:#000000;
            float:left;
       
          
            
        }
      
        #box01
        {
            height:200px;
            width:225px;
           // background-color:#000000;
            float:left;
            
          
        }
          #box02
        {
            height:200px;
            width:225px;
         //  background-color:#000000; 
            float:left;
       
           
        }
        #box03
        {
            height:200px;
            width:225px;
           // background-color:#000000;
            float:left;
        
          
            
        }
        
        #box10
        {
            height:200px;
            width:225px;
          //  background-color:#000000; 
            float: left;
           
            
        }
       
        #box11
        {
            height:200px;
            width:225px;
           // background-color:#000000; 
            float:left;
             
           
          
        }
        #box12
        {
            height:200px;
            width:225px;
           // background-color:#000000;
            float:left;
        
           
        }
        #box13
        {
            height:200px;
            width:225px;
           // background-color:#000000;
            float:left;
           
           
        }
        #box00:hover
        {
            background-color: #0000FF;
        }
        #box01:hover
        {
            background-color: #0000FF; 
        }
        
         #box02:hover
        {
            background-color: #0000FF;
        }
        #box03:hover
        {
            background-color: #0000FF; 
        }
          #box10:hover
        {
            background-color: #0000FF;
        }
          #box11:hover
        {
            background-color: #0000FF;
        }
          #box12:hover
        {
            background-color: #0000FF;
        }
         #box13:hover
        {
            background-color: #0000FF;
        }
        
       </style>
       <body style="background-color:#cccccc"><br>
    
       <center>
           <div id="Menu">
               <div id="hello">
                    <label style="float:left;font-size:20px;color:white;margin-left:20px;margin-top:5px;"><?php echo "Welcome ".$Hello; ?></label>
                   <form style="margin:0px" action="Login.php">
                   <input style="width:150px;height:35px;float:right;margin-top:5px;margin-right:20px;color:white;background-color:#0000FF;"type="submit" value="Logoff">
               </form>
                    <form style="margin:0px" action="UserPage.php">
                   <input style="width:150px;height:35px;float:right;margin-top:5px;margin-right:20px;color:white;background-color:#0000FF;"type="submit" value="UserPage">
               </form>
               </div><br>
               
               <div id="box1">
                  <div  id="box00">
                       <a href="students.php">  <img  src="\sabin\picture\directory.jpg" alt= " Image not found" style="padding:4px; height:191px; width:217px" ></a>
                   </div>
                   <div id="box01">
                       <a href="PublicGroup.php"> <img src="\sabin\picture\group.jpg" alt= " Image not found" style="padding:4px; height:191px; width:217px"></a>
                   </div>
                   <div id="box02">
                       <a href="Communication.php"> <img src="\sabin\picture\communication.jpg" alt= " Image not found" style="padding:4px; height:191px; width:217px" ></a>
                   </div>
                   <div id="box03">
                       <a href="InternalAdvertisement.php"> <img src="\sabin\picture\IntAdd.jpg" alt= " Image not found" style="padding:4px; height:191px; width:217px" ></a>
                   </div>
               </div>
               <div id="box2">
                   <div id="box10">
                       <a href="Market.php"> <img src="\sabin\picture\market.jpg" alt= " Image not found" style="padding:4px; height:191px; width:217px"></a>
                   </div>
                   <div id="box11">
                       <a href="Ratings.php"><img src="\sabin\picture\ratings.jpg" alt= " Image not found" style="padding:4px; height:191px; width:217px"></a>
                   </div>
                   <div id="box12">
                       <a href="Search.php"><img src="\sabin\picture\search.jpg" alt= " Image not found" style="padding:4px; height:191px; width:217px"></a>
                   </div>
                   <div id="box12">
                       <a href="ExternalAdvertisement.php"><img src="\sabin\picture\ExtAdd.png" alt= " Image not found" style="padding:4px; height:191px; width:217px"></a>
                   </div>
               </div>
               
             
       
            
           </div><!--Menu--></center>
    </body>
</html>