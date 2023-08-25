package org.c_shooters;

import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

public class Alarm{

    private Timer timer;



    public static void main(String[] args) {
        Alarm alarm = new Alarm();

        int[] intervals = alarm.getInputFromTerminal();
        alarm.startAlarm(intervals[0], intervals[1]);


        System.out.println(Thread.currentThread().getName());









    }

    private void startAlarm(int numRings, int ringInterval) {
        timer = new Timer();
        timer.scheduleAtFixedRate(new Ring(numRings),ringInterval * 1000,ringInterval* 1000);

    }


    private int[] getInputFromTerminal() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Number of times to ring the alarm ?");
        int numRings = scanner.nextInt();

        System.out.println("Ring interval in seconds ?");
        int ringInterval = scanner.nextInt();

        return new int[]{numRings, ringInterval};

    }

    private class Ring extends TimerTask{


        private int numRings;

        public Ring(int numRings){
            this.numRings = numRings;
        }


        @Override
        public void run() {


            System.out.println(Thread.currentThread().getName());
            System.out.println("Alarm is ringing...trim...trim");
            numRings--;

            for(int i = 0; i < 1000000000; i++){


                if (numRings <= 0) {
                    System.out.println("Alaram cancelled.");
                    timer.cancel();
                    break;
                }

            }


        }


    }


}
