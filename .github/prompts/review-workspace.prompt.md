---
description: "Review workspace files for actionable bugs and quality issues"
model: "Claude Haiku 4.5 (copilot)"
---
Review the current workspace for actionable issues.

- Inspect the project source files and relevant configuration and documentation.
- Exclude generated output, build artifacts, dependencies, and version-control metadata.
- Focus on concrete bugs, incorrect behavior, unsafe assumptions, and significant maintainability issues.
- Do not modify files.
- Report only actionable findings. For each finding, include severity, file and line number, a concise explanation of the impact, and a suggested fix.
- If no actionable issues are found, state that clearly.
