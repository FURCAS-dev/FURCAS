/**
 * 
 */
package org.modelversioning.ecoremutator.mutations;

import java.util.Random;

/**
 * @author martin.hanysz
 *
 * This is a seeded version of the model provider.
 * It is possible to repeat the sequence of generated random numbers by providing the same seed to two instances.
 */
public class SeededModelProvider extends ModelProvider {
    public SeededModelProvider(long seed) {
        super();
        random = new Random(seed);
    }
    
    public Random getRandomGenerator(){
        return random;
    }
    
    public void setRandomGenerator(Random newGenerator){
        random = newGenerator;
    }
}
