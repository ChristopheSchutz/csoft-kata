export function find(haystack: number[], needle: number): number {
    haystack.sort((a, b) => a - b);
    let low = 0;
    let high = haystack.length - 1;

    while (low <= high) {
        const mid = Math.floor((low + high) / 2);
        const midValue = haystack[mid];

        if (midValue === needle) {
            return mid;
        } else if (midValue < needle) {
            low = mid + 1;
        } else {
            high = mid - 1;
        }
    }

    throw new Error("Value not in array");
}