---
description: "Count Java source files in the workspace"
---
Count the Java files in the current workspace.

- Find files with the `.java` extension, case-insensitively.
- Include application and test source files.
- Exclude version-control, dependency, and generated build directories such as `.git`, `node_modules`, `target`, `build`, and `out`.
- Count each file once.
- Report the total count and a concise breakdown by directory. Mention which directories were excluded.
- Do not modify any files.
