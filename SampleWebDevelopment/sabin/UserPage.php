<?php
require'connect.php';



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
        
        

       $result = mysql_query("SELECT * FROM IntAdd");
       
      

        while($row = mysql_fetch_array($result))
        {
           // header("Content-type: image/jpeg");
            $Address2="/sabin/picture/".$row['IntAdd'];
           
        }
        //echo $Address2;
        ?>








<html>
    <head >
    <div style="height:200px">
        <center> <img src="\sabin\picture\header.jpg" alt= " Image not found" style="height:125px;width:906px;margin:0;padding:0"></center>
        
    </div>
    </head>
    <style>
        
        #container
            {
            height:405px;
            width:900px;
            background-color:#cccccc;
           
            }
         
        #welcome
        {
            height:35px;
            width:900px;
            background:#006666;
        }
        #Menu
        {
            height : 304px;
            width: 464px;
           // border-style: solid;
           // border-width: 1px;
          //  background-color: #B8860B;
            margin:0px;
            float:left;
           
        }
          #Advertisement
        {
            height:304px;
            width:400px;
            border-style:solid;
            border-width:1px;
            float:right;
            
        }
  
        
      
       
        #box1
        {
           height:152px;
           width:464px;
          // background-color:#000000;
         
           
        }
        #box2
        {
           height:152px;
           width:464px;
          // background-color:#000000; 
        }
       
        #box00
        {
            height:152px;
            width:154px;
           // background-color:#000000;
            float:left;
        
            
        }
        
        #box01
        {
            height:152px;
            width:154px;
          //  background-color:#000000;
            float:left;
           
        }
          #box02
        {
            height:152px;
            width:154px;
           // background-color:#000000; 
            float:left;
          
        }
        #box10
        {
            height:152px;
            width:152px;
           // background-color:#000000; 
            float: left;
            
        }
       
        #box11
        {
            height:152px;
            width:154px;
           // background-color:#000000; 
            float:left;
           
          
        }
        #box12
        {
            height:152px;
            width:154px;
          //  background-color:#000000;
            float:left;
          
        }
        #box00:hover
        {
            background-color:#0000FF;
        }
        #box01:hover
        {
            background-color: #0000FF;
        }
          #box02:hover
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
    
        
       </style>
      <body style="background-color:#cccccc">
      
       
      <center>  <div id="container" >
           <div id='welcome'>
            <label style="float:left;font-size:20px;margin-top:2px;margin-left:20px;color:white;"><?php echo "Welcome ".$Hello; ?></label>
            <form action='Login.php'>
           <input style="float:right;height:25px;width:150px;background-color:#0000FF;color:white;margin-top:5px;margin-right:20px" type="submit" value='Log Off'>
           </form>
               </div>
              <br><br>
           <div id="Menu">
               <div id="box1">
                   <div  id="box00">
                       <a href="students.php">  <img  src="\sabin\picture\directory.jpg" alt= " Image not found" style="padding:3; height:146; width:148" ></a>
                   </div>
                   <div id="box01">
                       <a href="PublicGroup.php"> <img src="\sabin\picture\group.jpg" alt= " Image not found" style="padding:3; height:146; width:148"></a>
                   </div>
                   <div id="box02">
                       <a href="Communication.php"> <img src="\sabin\picture\communication.jpg" alt= " Image not found" style="padding:3; height:146; width:148" ></a>
                   </div>
               </div>
               <div id="box2">
                   <div id="box10">
                       <a href="Market.php"> <img src="\sabin\picture\market.jpg" alt= " Image not found" style="padding:3; height:146; width:146"></a>
                   </div>
                   <div id="box11">
                       <a href="Ratings.php"><img src="\sabin\picture\ratings.jpg" alt= " Image not found" style="padding:3; height:146; width:148"></a>
                   </div>
                   <div id="box12">
                       <a href="Search.php"><img src="\sabin\picture\search.jpg" alt= " Image not found" style="padding:3; height:146; width:148"></a>
                   </div>
               </div>
               
           </div><!--Menu-->
           <div id="Advertisement">
              
                   <img   style=" height:304; width:400" alt= " Image not found"src=<?php echo $Address2;?>>
                 
           </div><!advertisement-->
          </div></center><!--container-->
       </body>
</html>