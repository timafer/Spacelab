import java.awt.Color;
import java.util.Random;
import java.util.Scanner;

import greenfoot.GreenfootImage;
import greenfoot.World;

public class SpaceWorld extends World {
	private static final int WORLD_WIDTH=1000;
	private static final int WORLD_HEIGHT=750;
	private static final int CELL_SIZE=1;
	private static final int MIDX=WORLD_WIDTH/2;
	private static final int MIDY=WORLD_HEIGHT/3;
	private static final int EARTH_Y=(WORLD_HEIGHT/3)*2;
	private static final int EARTH_X=WORLD_WIDTH/8;
	private static final int MOON_PY=0;
	private static final int MOON_PX=0;
	public SpaceWorld(){
	super(WORLD_WIDTH,WORLD_HEIGHT,CELL_SIZE);
	Random R= new Random();
	GreenfootImage back=getBackground();
	Scanner scan=new Scanner(System.in);
	System.out.println("Please enter a background color");
	String colo=scan.nextLine();
	switch (colo){
	case "white":
		back.setColor(Color.white);
	break;
	case "black":
		back.setColor(Color.black);
		break;
	case "red":
		back.setColor(Color.red);
		break;
	case "green":
		back.setColor(Color.green);
		break;
	case "gray":
		back.setColor(Color.gray);
		break;
		default:
			back.setColor(Color.black);
	}
	back.fill();
	if (colo.equals("white")){
			back.setColor(Color.black);
	}else{
	back.setColor(Color.WHITE);}
	for (int p=0;p<100;p++){
		int rx=R.nextInt(WORLD_WIDTH);
		int ry=R.nextInt(WORLD_HEIGHT);
		int rs=R.nextInt(5);
		back.fillOval(rx,ry,rs,rs);	}
	GreenfootImage star=new GreenfootImage("C:\\Users\\Timafer\\Desktop\\Java\\SpaceLab\\Images\\star.png");
	GreenfootImage saturn=new GreenfootImage("C:\\Users\\Timafer\\Desktop\\Java\\SpaceLab\\Images\\Saturn.png");
	GreenfootImage mars=new GreenfootImage("C:\\Users\\Timafer\\Desktop\\Java\\SpaceLab\\Images\\RedPlanet.png");
	GreenfootImage moon=new GreenfootImage("C:\\Users\\Timafer\\Desktop\\Java\\SpaceLab\\Images\\Moon.png");
	GreenfootImage earth=new GreenfootImage("C:\\Users\\Timafer\\Desktop\\Java\\SpaceLab\\Images\\HalfEarth.png");
	int mx=R.nextInt(WORLD_WIDTH-moon.getWidth());
	int my=R.nextInt((WORLD_HEIGHT-earth.getHeight())-moon.getHeight());
	int sy =0;
	int sx=0;
	int may=0;
	int max=0;
	if (mx<MIDX&&my<MIDY){
		sx=R.nextInt(MIDX)+MIDX;
		sy=R.nextInt((MIDY)+MIDY);}
		else if (mx>MIDX&&my<MIDY){
			sx=R.nextInt(MIDX);
			sy=R.nextInt(MIDY)+MIDY;}
		else if (my>MIDY){
			sx=R.nextInt(WORLD_WIDTH);
			sy=R.nextInt(MIDY+saturn.getHeight());}
	if (my<=sy){
		may=R.nextInt(EARTH_Y-my)+my;
	}else if (my>sy){
		may=R.nextInt(EARTH_Y-sy)+sy;
	}
	if (my<=sy&&mx<=sy){
		max=R.nextInt((WORLD_WIDTH-mars.getWidth())-mx)+mx;
	}else if (my>sy){
		max=R.nextInt((WORLD_WIDTH-mars.getWidth())-sx)+sx;}
	//if ((my+moon.getHeight()))
	//back.drawLine(0,MIDY,WORLD_WIDTH,MIDY);
	//back.drawLine(0,(MIDY*2),WORLD_WIDTH,(MIDY*2));
	//back.drawLine(WORLD_WIDTH/2, 0, WORLD_WIDTH/2, MIDY*2);
	if ((mx>MIDX||my>MIDY)&&(sx>MIDX||sy>MIDY)&&(max>MIDX||may>MIDY)){
		for (int x=0;x<=2;x+=1){
		int tx=R.nextInt(MIDX-star.getWidth());
		int ty=R.nextInt(MIDY);
		back.drawImage(star, tx, ty);}
	}
	if ((mx<MIDX||my>MIDY)&&(sx<MIDX||sy>MIDY)&&(max<MIDX||may>MIDY)){
		for (int x=0;x<=2;x+=1){
		int tx=R.nextInt(MIDX-star.getWidth())+MIDX;
		int ty=R.nextInt(MIDY);
		back.drawImage(star, tx, ty);}
	}
	if ((mx>MIDX||my<MIDY)&&(sx>MIDX||sy<MIDY)&&(max>MIDX||my<MIDY)){
		for (int x=0;x<=2;x+=1){
		int tx=R.nextInt(MIDX-star.getWidth());
		int ty=R.nextInt(MIDY)+MIDY;
		back.drawImage(star, tx, ty);}
	}
	if ((mx<MIDX||my<MIDY)&&(sx<MIDX||sy<MIDY)&&(max<MIDX||may<MIDY)){
		for (int x=0;x<=2;x+=1){
		int tx=R.nextInt(MIDX-star.getWidth())+MIDX;
		int ty=R.nextInt(MIDY)+MIDY;
		back.drawImage(star, tx, ty);}
	}
	back.drawImage(saturn, sx-saturn.getWidth(),sy);
	back.drawImage(mars,max,may);
	Scanner input=new Scanner(System.in);
	//System.out.println("Pls enter moon x postion");
	//int mx=input.nextInt();
	//System.out.println("Pls enter moon y postion");
	//int my=input.nextInt();
	back.drawImage(moon,mx-moon.getWidth(),my);
	back.drawImage(earth, EARTH_X, EARTH_Y);
	}
}
