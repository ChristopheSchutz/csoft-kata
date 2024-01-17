export class DnDCharacter {
    public static generateAbilityScore(): number {
        return sumRolls(4,3,6);
    }

    public static getModifierFor(abilityValue: number): number {
        return Math.floor((abilityValue - 10) / 2);
    }
}

export function sumRolls(numberOfRolls: number, numberOfRollsToKeep: number, maxRoll: number): number {
    const rolls = rollNTimes(numberOfRolls, maxRoll);
    rolls.sort((a, b) => a - b);
    let result = 0;
    while (numberOfRollsToKeep>0 && rolls.length>0) {
        const nextRoll = rolls.pop();
        if (nextRoll !== undefined) {
            result+=nextRoll;
        }
        numberOfRollsToKeep--;
    }
    return result;
}

export function rollNTimes(numberOfRolls: number, maxRoll: number): number[] {
    let results = [];
    for (let i = 0; i<numberOfRolls; i++) {
        results.push(roll(maxRoll));
    }
    return results;
}

export function roll(maxNumber: number): number {
    return Math.floor(Math.random() * maxNumber) + 1;
}
