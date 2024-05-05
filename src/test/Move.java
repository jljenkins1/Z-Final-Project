package test;
import java.util.ArrayList;
import java.util.List;

public class Move {
    private String name;
    private int power;
    private int accuracy;
    private PType type;
    private boolean isPhysical;
    private int speed;

    public Move(String name, int power, int accuracy, PType type, boolean isPhysical, int speed) {
        this.name = name;
        this.power = power;
        this.accuracy = accuracy;
        this.type = type;
        this.isPhysical = isPhysical;
        this.speed = speed;
    }
//getters and setters
    public String getName() {
        return name;
    }
    public int getSpeed() {
    	return speed;
    }public boolean isPhysical() {
        return isPhysical;
    }
    public PType getType() {
        return type;
    }public int getPower() {
    	return power;
    }

// factory to create movesets for each pokemon based on type
    public static class MoveFactory {
        public static List<Move> getMovesForType(PType type) {
            List<Move> moves = new ArrayList<>();
            switch (type) {
                case NORMAL:
                    moves.add(new Move("Tackle", 40, 100, PType.NORMAL, true, 80));
                    moves.add(new Move("Quick Attack", 40, 100, PType.NORMAL, true, 100));
                    moves.add(new Move("Tackle", 40, 100, PType.NORMAL, true, 30));
                    moves.add(new Move("Quick Attack", 40, 100, PType.NORMAL, true, 100));
                    break;
                case FIRE:
                    moves.add(new Move("Ember", 40, 100, PType.FIRE, false, 50));
                    moves.add(new Move("Flamethrower", 90, 100, PType.FIRE, false, 40));
                    moves.add(new Move("Fire Punch", 40, 80, PType.NORMAL, true, 10));
                    moves.add(new Move("Quick Attack", 40, 100, PType.NORMAL, true, 100));
                    break;
                case WATER:
                    moves.add(new Move("Bubble", 40, 100, PType.WATER, false, 70));
                    moves.add(new Move("Water Pump", 90, 100, PType.WATER, false, 50));
                    moves.add(new Move("Wave Crash", 80, 100, PType.WATER, false, 40));
                    moves.add(new Move("Quick Attack", 40, 100, PType.NORMAL, true, 100));
                    break;
                case PSYCHIC:
                    moves.add(new Move("Kenesis", 40, 100, PType.PSYCHIC, false,50));
                    moves.add(new Move("Psyblade", 90, 100, PType.PSYCHIC, true, 60));
                    moves.add(new Move("Tackle", 40, 100, PType.NORMAL, true, 30));
                    moves.add(new Move("Quick Attack", 40, 100, PType.NORMAL, true, 100));
                    break;
                case POISON:
                    moves.add(new Move("Acid", 40, 100, PType.POISON, false, 60));
                    moves.add(new Move("Poison Fang", 90, 100, PType.POISON, true, 70));
                    moves.add(new Move("Tackle", 40, 100, PType.NORMAL, true, 50));
                    moves.add(new Move("Quick Attack", 40, 100, PType.NORMAL, true, 100));
                    break;
                case METAL:
                    moves.add(new Move("Flash Cannon", 70, 100, PType.METAL, false, 20));
                    moves.add(new Move("Metal Burst", 90, 100, PType.METAL, true, 40));
                    moves.add(new Move("Tackle", 40, 100, PType.NORMAL, true, 50));
                    moves.add(new Move("Quick Attack", 40, 100, PType.NORMAL, true, 100));
                    break;
                case ICE:
                    moves.add(new Move("Ice Beam", 40, 100, PType.ICE, false, 50));
                    moves.add(new Move("Blizzard", 90, 100, PType.ICE, false, 20));
                    moves.add(new Move("Tackle", 40, 100, PType.NORMAL, true, 50));
                    moves.add(new Move("Quick Attack", 40, 100, PType.NORMAL, true, 100));
                    break;
                case GROUND:
                    moves.add(new Move("Sand Attack", 40, 100, PType.GROUND, false, 30));
                    moves.add(new Move("Fissure", 90, 100, PType.GROUND, false, 10));
                    moves.add(new Move("Tackle", 40, 100, PType.NORMAL, true, 50));
                    moves.add(new Move("Quick Attack", 40, 100, PType.NORMAL, true, 100));
                    break;
                case GRASS:
                    moves.add(new Move("Chloroblast", 40, 100, PType.GRASS, false, 60));
                    moves.add(new Move("Leaf Blade", 90, 100, PType.GRASS, true, 70));
                    moves.add(new Move("Tackle", 40, 100, PType.NORMAL, true, 50));
                    moves.add(new Move("Quick Attack", 40, 100, PType.NORMAL, true, 100));
                    break;
                case GHOST:
                    moves.add(new Move("Shadow Ball", 40, 100, PType.GHOST, false, 60));
                    moves.add(new Move("Shadow Claw", 30, 100, PType.GHOST, true, 30));
                    moves.add(new Move("Tackle", 40, 100, PType.NORMAL, true, 50));
                    moves.add(new Move("Quick Attack", 40, 100, PType.NORMAL, true, 100));
                    break;
                case FLYING:
                    moves.add(new Move("Aeroblast", 40, 100, PType.FLYING, false, 80));
                    moves.add(new Move("Brave Bird", 90, 100, PType.FLYING, true, 90));
                    moves.add(new Move("Tackle", 40, 100, PType.NORMAL, true, 50));
                    moves.add(new Move("Quick Attack", 40, 100, PType.NORMAL, true, 100));
                    break;
                case FIGHTING:
                    moves.add(new Move("Power Up Punch", 60, 100, PType.FIGHTING, true, 30));
                    moves.add(new Move("Body Press", 90, 100, PType.FIGHTING, true, 40));
                    moves.add(new Move("Tackle", 40, 100, PType.NORMAL, true, 50));
                    moves.add(new Move("Quick Attack", 40, 100, PType.NORMAL, true, 100));
                    break;
                case FAIRY:
                    moves.add(new Move("Misty Explosion", 40, 100, PType.FAIRY, false, 60));
                    moves.add(new Move("Aeromic Mist", 90, 100, PType.FAIRY, false, 70));
                    moves.add(new Move("Tackle", 40, 100, PType.NORMAL, true, 50));
                    moves.add(new Move("Quick Attack", 40, 100, PType.NORMAL, true, 100));
                    break;
                case ELECTRIC:
                    moves.add(new Move("Electro Ball", 40, 100, PType.ELECTRIC, false, 90));
                    moves.add(new Move("Bolt Strike", 90, 100, PType.ELECTRIC, true, 80));
                    moves.add(new Move("Tackle", 40, 100, PType.NORMAL, true, 50));
                    moves.add(new Move("Quick Attack", 40, 100, PType.NORMAL, true, 100));
                    break;
                case DRAGON:
                    moves.add(new Move("Draco Meteor", 40, 100, PType.DRAGON, true, 40));
                    moves.add(new Move("Dragon Claw", 90, 100, PType.DRAGON, true, 60));
                    moves.add(new Move("Tackle", 40, 100, PType.NORMAL, true, 50));
                    moves.add(new Move("Quick Attack", 40, 100, PType.NORMAL, true, 100));
                    break;
                case DARK:
                    moves.add(new Move("Night Slash", 40, 100, PType.DARK, true, 100));
                    moves.add(new Move("Dark Void", 95, 100, PType.WATER, false, 30));
                    moves.add(new Move("Tackle", 40, 100, PType.NORMAL, true, 50));
                    moves.add(new Move("Quick Attack", 40, 100, PType.NORMAL, true, 100));
                    break;
                case BUG:
                    moves.add(new Move("Bug Bite", 40, 100, PType.BUG, true, 80));
                    moves.add(new Move("Infestation", 90, 100, PType.WATER, false, 40));
                    moves.add(new Move("Tackle", 40, 100, PType.NORMAL, true, 50));
                    moves.add(new Move("Quick Attack", 40, 100, PType.NORMAL, true, 100));
                    break;
            }
            return moves;
        }
    }
    //creates a multipler for damage based on the type of the move and the type of the target
    public double getEffectivenessMultiplier(PType attackingType, PType defendingType) {
        // Define effectiveness multipliers
        double superEffectiveMultiplier = 2;
        double notVeryEffectiveMultiplier = 0.5;
        double noEffectMultiplier = 0.0;

        // Check effectiveness based on type matchup
        switch (attackingType) {
            case NORMAL:
                switch (defendingType) {
                    case GHOST:
                        return noEffectMultiplier;
                    default:
                        return 1.0; 
                }
            case FIRE:
                switch (defendingType) {
                    case WATER:
                    case GROUND:
                        return superEffectiveMultiplier;
                    case GRASS:
                        return superEffectiveMultiplier;
                    default:
                        return 1.0;
                }
            case WATER:
                switch (defendingType) {
                    case FIRE:
                    case GROUND:
                        return notVeryEffectiveMultiplier;
                    case GRASS:
                        return notVeryEffectiveMultiplier;
                    default:
                        return 1.0;
                }
            case ELECTRIC:
                switch (defendingType) {
                    case GROUND:
                        return notVeryEffectiveMultiplier;
                    case WATER:
                        return superEffectiveMultiplier;
                    default:
                        return 1.0;
                }
            case GRASS:
                switch (defendingType) {
                    case FIRE:
                        return notVeryEffectiveMultiplier;
                    case WATER:
                        return superEffectiveMultiplier;
                    default:
                        return 1.0;
                }
            case ICE:
                switch (defendingType) {
                    case WATER:
                    case FIRE:
                        return notVeryEffectiveMultiplier;
                    case GRASS:
                    case FLYING:
                        return superEffectiveMultiplier;
                    default:
                        return 1.0;
                }
            case FIGHTING:
                switch (defendingType) {
                    case FLYING:
                    case PSYCHIC:
                        return notVeryEffectiveMultiplier;
                    case NORMAL:
                        return superEffectiveMultiplier;
                    case GHOST:
                    	return noEffectMultiplier;
                    default:
                        return 1.0;
                }
               

            default:
                return 1.0; // Default to neutral effectiveness
        }
    }

}
