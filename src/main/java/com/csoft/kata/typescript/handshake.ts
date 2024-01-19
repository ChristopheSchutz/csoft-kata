export function commands(command: number): string[] {
    const binary = command.toString(2).split('').reverse();
    const result = binary
        .slice(0, ACTIONS.length)
        .map((bit, index) => bit === '1' ? ACTIONS[index] : null)
        .filter(Boolean);

    if (binary[ACTIONS.length] === '1') {
        result.reverse();
    }

    return result;
}

export const ACTIONS = ["wink", "double blink", "close your eyes", "jump"];

// NB
// toString(radix) => binary
// map with filter(Boolean) => remove null & undefined values