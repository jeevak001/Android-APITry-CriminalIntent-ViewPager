package com.jeevscode.jeeva.criminalintent;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Created by jeeva on 22/09/17.
 */

public class CrimeLab {

    private static CrimeLab crimeLab;
    private List<Crime> crimeList;

    public static CrimeLab get(Context context){

        if(crimeLab == null){
            crimeLab = new CrimeLab(context);
        }

        return crimeLab;
    }


    private CrimeLab (Context ctx){

        crimeList = new ArrayList<Crime>();
        for (int i = 0; i < 100; i++) {
            Crime crime = new Crime();
            crime.setTitle("Crime #" + i);
            crime.setSolved(i % 2 == 0);
            crimeList.add(crime);
        }
    }

    public List<Crime> getCrimes(){

        return crimeList;
    }

    public Crime getCrime(UUID id) {

        for (Crime crime : crimeList) {
            if (crime.getId().equals(id)) {
                return crime;
            }
        }

        return null;
    }
}
