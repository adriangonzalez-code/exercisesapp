package com.exerciseapp.app.services;

import com.exerciseapp.app.enums.ExerciseTypeEnum;
import com.exerciseapp.app.models.Verb;
import com.exerciseapp.app.objects.DummyObjects;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ExerciseServiceImpl {
    
    private List<Integer> pastPos = new ArrayList<>();
    private List<Verb> verbs;
    private final Random R = new Random();
    private int pos;
    ExerciseTypeEnum exerciseType;

    public ExerciseServiceImpl(ExerciseTypeEnum exerciseType) {
        this.exerciseType = exerciseType;
        this.verbs = this.getVerbsForExercise(this.exerciseType);
        
        this.pastPos.add(this.pos);
    }
    
    public String getMeaning() {
        
        do {
            if (this.pastPos.size() == this.verbs.size()) {
                this.pastPos = new ArrayList<>();
            }
            
            this.pos = this.getNewPosition();
        } while (this.pastPos.contains(this.pos));
        
        System.out.println("New pos: " + this.pos);
        this.pastPos.add(this.pos);
        return this.verbs.get(this.pos).getMeaning();
    }
    
    public String getVerb() {
        return this.verbs.get(this.pos).getVerb();
    }
    
    public boolean isCorrect(String currentValue) {
        System.out.println("currentValue: " + currentValue);
        System.out.println("verb: " + this.getVerb());
        
        return currentValue.equalsIgnoreCase(this.getVerb());
    }
    
    private int getNewPosition() {
        return R.nextInt(this.verbs.size());
    }
    
    private List<Verb> getVerbsForExercise(ExerciseTypeEnum exerciseType) {
        
        switch(exerciseType) {
            case EXERCISE_A:
                return DummyObjects.getObjectForExerciseA();
                
            case EXERCISE_B:
                return DummyObjects.getObjectForExerciseB();
                
            default:
                return null;
        }
    }
}