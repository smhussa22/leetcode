param (
    [Parameter(Mandatory=$true)]
    [string]$ClassName
)

$SRC_DIR = "src"
$BIN_DIR = "bin"

if (!(Test-Path $BIN_DIR)) {
    New-Item -ItemType Directory $BIN_DIR | Out-Null
}

Write-Host "Compiling..."
javac -d $BIN_DIR $SRC_DIR\*.java

if ($LASTEXITCODE -ne 0) {
    exit 1
}

Write-Host "Running $ClassName..."
java -cp $BIN_DIR src.$ClassName
